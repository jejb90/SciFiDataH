package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.*;
import com.challenge.challenge.dto.CharacterApi;
import com.challenge.challenge.service.CharacterService;
import com.challenge.challenge.service.EpisodeService;
import com.challenge.challenge.service.LocationService;
import com.challenge.challenge.service.RickAndMortyApiService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class RickAndMortyApiServiceImpl implements RickAndMortyApiService {
    private final RestTemplate restTemplate;
    private final LocationService locationService;
    private final EpisodeService episodeService;
    private final CharacterService characterService;

    private List<Long> characterIds;

    @Autowired
    public RickAndMortyApiServiceImpl(
            RestTemplate restTemplate,
            LocationService locationService,
            EpisodeService episodeService,
            CharacterService characterService
    ) {
        this.restTemplate = restTemplate;
        this.locationService = locationService;
        this.episodeService = episodeService;
        this.characterService = characterService;
        this.characterIds = new ArrayList<>();
    }

    @Override
    public EpisodeWithDetails getEpisodeDetails(int episodeId) {
        String episodeUrl = "https://rickandmortyapi.com/api/episode/" + episodeId;
        EpisodeApi episode = restTemplate.getForObject(episodeUrl, EpisodeApi.class);

        List<CharacterWithLocation> charactersWithLocations = episode.getCharacters().stream()
                .map(characterUrl -> restTemplate.getForObject(characterUrl, CharacterApi.class))
                .map(character -> processCharacter(character))
                .collect(Collectors.toList());

        EpisodeDTO episodeDTO = episodeService.searchByNumberEpisode(episode.getEpisode());
        if (episodeDTO == null) {
            episodeDTO = createEpisodeDTO(episode);
        }

        return new EpisodeWithDetails(
                episode.getId(),
                episode.getName(),
                episode.getEpisode(),
                charactersWithLocations
        );
    }

    private CharacterWithLocation processCharacter(CharacterApi character) {
        CharacterWithLocation characterWithLocation = new CharacterWithLocation();
        characterWithLocation.setId(character.getId());
        characterWithLocation.setName(character.getName());
        characterWithLocation.setStatus(character.getStatus());
        characterWithLocation.setSpecies(character.getSpecies());
        characterWithLocation.setGender(character.getGender());
        characterWithLocation.setImage(character.getImage());

        CharacterDTO characterDTO = characterService.searchByName(character.getName());
        if (characterDTO == null) {
            characterDTO = new CharacterDTO();
            if (!character.getLocation().getUrl().isEmpty()) {
                LocationWithCharacter location = restTemplate.getForObject(character.getLocation().getUrl(), LocationWithCharacter.class);
                characterWithLocation.setLocation(location);

                LocationDTO locationDTO = locationService.searchByName(location.getName());
                if (locationDTO == null) {
                    locationDTO = createLocationDTO(location);
                    characterDTO.setLocation(locationDTO);
                }
            }
            characterDTO = createCharacterDTO(character, characterDTO);
        }

        characterIds.add(characterDTO.getId());

        return characterWithLocation;
    }

    private CharacterDTO createCharacterDTO(CharacterApi character, CharacterDTO characterLocationDTO) {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(character.getName());
        characterDTO.setSpecies(character.getSpecies());
        characterDTO.setGender(character.getGender());
        characterDTO.setImage(character.getImage());
        characterDTO.setLocation(characterLocationDTO.getLocation());
        return characterService.saveCharacter(characterDTO);
    }

    private LocationDTO createLocationDTO(LocationWithCharacter location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setName(location.getName());
        locationDTO.setDimension(location.getDimension());
        return locationService.saveLocation(locationDTO);
    }

    private EpisodeDTO createEpisodeDTO(EpisodeApi episode) {
        EpisodeDTO episodeDTO = new EpisodeDTO();
        episodeDTO.setNumberEpisode(episode.getEpisode());
        episodeDTO.setName(episode.getName());
        return episodeService.saveEpisode(episodeDTO, characterIds);
    }
}

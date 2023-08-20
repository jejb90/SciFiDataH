package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.*;
import com.challenge.challenge.dto.CharacterApi;
import com.challenge.challenge.service.RickAndMortyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RickAndMortyApiServiceImpl implements RickAndMortyApiService {
    private final RestTemplate restTemplate;
    @Autowired
    public RickAndMortyApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EpisodeWithDetails getEpisodeDetails(int episodeId) {
        String episodeUrl = "https://rickandmortyapi.com/api/episode/" + episodeId;
        EpisodeApi episode = restTemplate.getForObject(episodeUrl, EpisodeApi.class);

        List<CharacterWithLocation> charactersWithLocations = episode.getCharacters().stream()
                .map(characterUrl -> restTemplate.getForObject(characterUrl, CharacterApi.class))
                .map(character -> {
                    CharacterWithLocation characterWithLocation = new CharacterWithLocation();
                    characterWithLocation.setId(character.getId());
                    characterWithLocation.setName(character.getName());
                    characterWithLocation.setStatus(character.getStatus());
                    characterWithLocation.setSpecies(character.getSpecies());
                    characterWithLocation.setGender(character.getGender());
                    characterWithLocation.setImage(character.getUrl());

                    if (!character.getLocation().getUrl().isEmpty()) {
                        LocationWithCharacter location = restTemplate.getForObject(character.getLocation().getUrl(), LocationWithCharacter.class);
                        characterWithLocation.setLocation(location);
                    }

                    return characterWithLocation;
                })
                .collect(Collectors.toList());

        return new EpisodeWithDetails(
                episode.getId(),
                episode.getName(),
                episode.getEpisode(),
                charactersWithLocations
        );
    }
}

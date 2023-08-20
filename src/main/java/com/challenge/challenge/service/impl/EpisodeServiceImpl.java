package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.entities.Episode;
import com.challenge.challenge.exceptions.ResourceNotFoundException;
import com.challenge.challenge.repository.EpisodeRepository;
import com.challenge.challenge.service.CharacterService;
import com.challenge.challenge.service.EpisodeCharacterService;
import com.challenge.challenge.service.EpisodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private EpisodeRepository episodeRepository;

    private CharacterService characterService;

    private EpisodeCharacterService episodeCharacterService;
    private final ModelMapper modelMapper;

    @Autowired
    public EpisodeServiceImpl(EpisodeRepository episodeRepository, CharacterService characterService, EpisodeCharacterService episodeCharacterService, ModelMapper modelMapper) {
        this.episodeRepository = episodeRepository;
        this.characterService = characterService;
        this.episodeCharacterService = episodeCharacterService;
        this.modelMapper = modelMapper;
    }

    @Autowired

    public List<EpisodeDTO> getAllEpisodes() {
        return episodeRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }

    public EpisodeDTO searchById(Long id) {
        return mapDTO(episodeRepository.findById(id).get());
    }

    public EpisodeDTO searchByNumberEpisode(String numberEpisode) {
        return mapDTO(episodeRepository.findByNumberEpisode(numberEpisode));
    }

    public EpisodeDTO saveEpisode(EpisodeDTO episodeDTO, List<Long> charactersIds) {
        EpisodeDTO episodeDTOSave = mapDTO(episodeRepository.save(mapEntity(episodeDTO)));
        List<CharacterDTO> characters = new ArrayList<>();
        List<Long> uniqueCharacterIds = new ArrayList<>(new HashSet<>(charactersIds));
        for (Long characterId : uniqueCharacterIds) {
            CharacterDTO characterDTO = characterService.searchById(characterId);
            characters.add(characterDTO);
            episodeCharacterService.saveEpisodeCharacter(episodeDTOSave, characterDTO);
        }
        return episodeDTO;
    }

    public void deleteEpisode(Long id) {
        Episode episode = episodeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Episode", "id", id));
        episodeRepository.delete(episode);
    }

    private Episode mapEntity(EpisodeDTO episodeDTO) {
        return modelMapper.map(episodeDTO, Episode.class);
    }

    private EpisodeDTO mapDTO(Episode episode) {
        if (episode == null) {
            return null;
        }
        return modelMapper.map(episode, EpisodeDTO.class);

    }
}

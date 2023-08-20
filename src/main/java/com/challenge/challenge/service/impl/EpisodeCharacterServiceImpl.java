package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.dto.EpisodeCharacterDTO;
import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.entities.Character;
import com.challenge.challenge.entities.Episode;
import com.challenge.challenge.entities.EpisodeCharacter;
import com.challenge.challenge.repository.EpisodeCharacterRepository;
import com.challenge.challenge.service.EpisodeCharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EpisodeCharacterServiceImpl implements EpisodeCharacterService {

    private final ModelMapper modelMapper;
    private final EpisodeCharacterRepository episodeCharacterRepository;

    public EpisodeCharacterServiceImpl(ModelMapper modelMapper, EpisodeCharacterRepository episodeCharacterRepository) {
        this.modelMapper = modelMapper;
        this.episodeCharacterRepository = episodeCharacterRepository;
    }

    public EpisodeCharacterDTO saveEpisodeCharacter(EpisodeDTO episodeDTO, CharacterDTO characterDTO){
        Episode episode = mapEpisode(episodeDTO);
        Character character = mapCharacter(characterDTO);
        EpisodeCharacter episodeCharacter = new EpisodeCharacter();
        episodeCharacter.setCharacter(character);
        episodeCharacter.setEpisode(episode);

        return mapDTO(episodeCharacterRepository.save(episodeCharacter));
    }

    private EpisodeCharacter mapEntity(EpisodeCharacterDTO episodeCharacterDTO) {
        return modelMapper.map(episodeCharacterDTO, EpisodeCharacter.class);
    }

    private EpisodeCharacterDTO mapDTO(EpisodeCharacter episodeCharacter) {
        return modelMapper.map(episodeCharacter, EpisodeCharacterDTO.class);
    }

    private Character mapCharacter(CharacterDTO characterDTO) {
        return modelMapper.map(characterDTO, Character.class);
    }

    private CharacterDTO mapCharacterDTO(Character character) {
        return modelMapper.map(character, CharacterDTO.class);
    }
    private Episode mapEpisode(EpisodeDTO episodeDTO) {
        return modelMapper.map(episodeDTO, Episode.class);
    }

    private EpisodeDTO mapEpisodeDTO(Episode episode) {
        return modelMapper.map(episode, EpisodeDTO.class);
    }
}

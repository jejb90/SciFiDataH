package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.dto.EpisodeCharacterDTO;
import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.entities.Character;
import com.challenge.challenge.entities.Episode;
import com.challenge.challenge.entities.EpisodeCharacter;
import com.challenge.challenge.repository.CharacterRepository;
import com.challenge.challenge.repository.EpisodeCharacterRepository;
import com.challenge.challenge.repository.EpisodeRepository;
import com.challenge.challenge.service.EpisodeCharacterService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class EpisodeCharacterServiceImplTest {


    private final EpisodeCharacterService episodeCharacterService;

    private final EpisodeCharacterRepository episodeCharacterRepository;

    private final EpisodeRepository episodeRepository;

    private final CharacterRepository characterRepository;

    @Autowired
    public EpisodeCharacterServiceImplTest(EpisodeCharacterService episodeCharacterService, EpisodeCharacterRepository episodeCharacterRepository, EpisodeRepository episodeRepository, CharacterRepository characterRepository) {
        this.episodeCharacterService = episodeCharacterService;
        this.episodeCharacterRepository = episodeCharacterRepository;
        this.episodeRepository = episodeRepository;
        this.characterRepository = characterRepository;
    }


    @Test
    public void testSaveEpisodeCharacter() {


        EpisodeDTO episodeDTO = new EpisodeDTO();

        CharacterDTO characterDTO = new CharacterDTO();

        Episode episode = new Episode();
        episode.setName("NameTest");
        episode.setNumberEpisode("S01EETest");

        Character character = new Character();
        character.setName("NameTest");

        Episode savedEpisode = episodeRepository.save(episode);
        Character savedCharacter = characterRepository.save(character);

        characterDTO.setId(savedCharacter.getId());
        episodeDTO.setId(savedEpisode.getId());


        EpisodeCharacterDTO episodeCharacterDTO = episodeCharacterService.saveEpisodeCharacter(episodeDTO, characterDTO);

        EpisodeCharacter savedEpisodeCharacter = episodeCharacterRepository.findById(episodeCharacterDTO.getId()).orElse(null);

        assertNotNull(savedEpisodeCharacter);
        assertEquals(savedEpisode.getId(), savedEpisodeCharacter.getEpisode().getId());
        assertEquals(savedCharacter.getId(), savedEpisodeCharacter.getCharacter().getId());

    }

}
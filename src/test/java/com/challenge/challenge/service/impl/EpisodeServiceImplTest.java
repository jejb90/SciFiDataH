package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.entities.Character;
import com.challenge.challenge.entities.Episode;
import com.challenge.challenge.repository.EpisodeRepository;
import com.challenge.challenge.service.CharacterService;
import com.challenge.challenge.service.EpisodeCharacterService;
import com.challenge.challenge.service.EpisodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class EpisodeServiceImplTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private EpisodeService episodeService;

    @Test
    public void testSaveEpisode() {
        EpisodeDTO episodeDTO = new EpisodeDTO();
        CharacterDTO character = new CharacterDTO();
        character.setName("Rick");
        character = characterService.saveCharacter(character);
        episodeDTO.setName("Test Episode");
        episodeDTO.setNumberEpisode("S01E01");
        List<Long> characterIds = new ArrayList<>();
        characterIds.add(character.getId());

        EpisodeDTO savedEpisode = episodeService.saveEpisode(episodeDTO, characterIds);
        Episode retrievedEpisode = episodeRepository.findById(savedEpisode.getId()).get();

        assertNotNull(retrievedEpisode);
        assertEquals(episodeDTO.getName(), retrievedEpisode.getName());
        assertEquals(episodeDTO.getNumberEpisode(), retrievedEpisode.getNumberEpisode());
    }

    @Test
    public void testSearchById() {
        EpisodeDTO episodeDTO = new EpisodeDTO();
        episodeDTO.setName("Test Episode");
        episodeDTO.setNumberEpisode("S01E01");

        List<Long> characterIds = characterService.getAllCharacters().stream()
                .map(CharacterDTO::getId)
                .collect(Collectors.toList());

        EpisodeDTO savedEpisode = episodeService.saveEpisode(episodeDTO, characterIds);
        Long savedEpisodeId = savedEpisode.getId();

        EpisodeDTO retrievedEpisode = episodeService.searchById(savedEpisodeId);

        assertNotNull(retrievedEpisode);
        assertEquals(savedEpisodeId, retrievedEpisode.getId());
        assertEquals(episodeDTO.getName(), retrievedEpisode.getName());
        assertEquals(episodeDTO.getNumberEpisode(), retrievedEpisode.getNumberEpisode());
    }
}
package com.challenge.challenge.service;

import com.challenge.challenge.dto.EpisodeWithDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RickAndMortyApiServiceTest {

    @Autowired
    private RickAndMortyApiService rickAndMortyApiService;
    @Test
    void testGetEpisodeDetails() {
        EpisodeWithDetails episodeWithDetails = rickAndMortyApiService.getEpisodeDetails(1);

        assertEquals(1, episodeWithDetails.getId());
        assertEquals("Pilot", episodeWithDetails.getName());
        assertEquals("S01E01", episodeWithDetails.getEpisode());
    }
}

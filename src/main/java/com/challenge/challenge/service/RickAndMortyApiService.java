package com.challenge.challenge.service;

import com.challenge.challenge.dto.EpisodeWithDetails;

@FunctionalInterface
public interface RickAndMortyApiService {
    EpisodeWithDetails getEpisodeDetails(int episodeId);
}

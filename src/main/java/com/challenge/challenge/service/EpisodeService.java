package com.challenge.challenge.service;

import com.challenge.challenge.dto.EpisodeDTO;

import java.util.List;

public interface EpisodeService {

    List<EpisodeDTO> getAllEpisodes();

    EpisodeDTO searchById(Long id);
    EpisodeDTO searchByNumberEpisode(String numberEpisode);

    EpisodeDTO saveEpisode(EpisodeDTO episodeDTO, List<Long> characters);

    void deleteEpisode(Long id);
}

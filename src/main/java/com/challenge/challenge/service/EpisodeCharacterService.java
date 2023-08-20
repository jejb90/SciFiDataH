package com.challenge.challenge.service;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.dto.EpisodeCharacterDTO;
import com.challenge.challenge.dto.EpisodeDTO;

public interface EpisodeCharacterService {
    EpisodeCharacterDTO saveEpisodeCharacter(EpisodeDTO episodeDTO, CharacterDTO characterDTO);
}

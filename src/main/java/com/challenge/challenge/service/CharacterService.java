package com.challenge.challenge.service;

import com.challenge.challenge.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getAllCharacters();
    CharacterDTO searchById(Long id);

    CharacterDTO searchByName(String name);
    CharacterDTO saveCharacter(CharacterDTO characterDTO);
    CharacterDTO updateCharacter(CharacterDTO characterDTO, Long id);
    void deleteCharacter(Long id);
}

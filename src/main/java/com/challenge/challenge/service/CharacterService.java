package com.challenge.challenge.service;

import com.challenge.challenge.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getAllCharacters();
    public CharacterDTO searchById(Long id);

    public CharacterDTO saveCharacter(CharacterDTO characterDTO);
    public CharacterDTO updateCharacter(CharacterDTO characterDTO, Long id);

    public void deleteCharacter(Long id);
}

package com.challenge.challenge.service;

import com.challenge.challenge.dto.CharacterDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CharacterService {

    List<CharacterDTO> getAllCharacters();
    CharacterDTO searchById(Long id);

    CharacterDTO searchByName(String name);
    CharacterDTO saveCharacter(CharacterDTO characterDTO);
    CharacterDTO updateCharacter(CharacterDTO characterDTO, Long id);
    void deleteCharacter(Long id);
}

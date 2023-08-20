package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.entities.Character;
import com.challenge.challenge.repository.CharacterRepository;
import com.challenge.challenge.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class CharacterServiceImplTest {


    private final CharacterRepository characterRepository;

    private final CharacterService characterService;

    @Autowired
    public CharacterServiceImplTest(CharacterRepository characterRepository, CharacterService characterService) {
        this.characterRepository = characterRepository;
        this.characterService = characterService;
    }

    @Test
    public void testGetAllCharacters() {
        Character character1 = new Character();
        character1.setName("Rick");
        characterRepository.save(character1);

        Character character2 = new Character();
        character2.setName("Morty");
        characterRepository.save(character2);

        List<CharacterDTO> characterDTOs = characterService.getAllCharacters();

        assertEquals(2, characterDTOs.size());
    }

    @Test
    public void testSearchById() {
        Character character = new Character();
        character.setName("Rick");
        characterRepository.save(character);

        CharacterDTO result = characterService.searchById(character.getId());

        assertNotNull(result);
        assertEquals(character.getName(), result.getName());
    }

    @Test
    public void testSearchByName() {
        Character character = new Character();
        character.setName("Rick");
        characterRepository.save(character);

        CharacterDTO result = characterService.searchByName(character.getName());

        assertNotNull(result);
        assertEquals(character.getName(), result.getName());
    }

    @Test
    public void testSaveCharacter() {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Rick");

        CharacterDTO result = characterService.saveCharacter(characterDTO);

        assertNotNull(result);
        assertEquals(characterDTO.getName(), result.getName());
    }

    @Test
    public void testUpdateCharacter() {
        Character character = new Character();
        character.setName("Rick");
        characterRepository.save(character);

        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Morty");
        characterDTO.setGender("Male");

        CharacterDTO result = characterService.updateCharacter(characterDTO, character.getId());

        assertNotNull(result);
        assertEquals(characterDTO.getName(), result.getName());
    }

    @Test
    public void testDeleteCharacter() {
        Character character = new Character();
        character.setName("Rick");
        characterRepository.save(character);

        characterService.deleteCharacter(character.getId());

        assertFalse(characterRepository.existsById(character.getId()));
    }
}

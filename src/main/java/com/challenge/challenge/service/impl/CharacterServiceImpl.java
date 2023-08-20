package com.challenge.challenge.service.impl;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.entities.Character;
import com.challenge.challenge.exceptions.ResourceNotFoundException;
import com.challenge.challenge.repository.CharacterRepository;
import com.challenge.challenge.service.CharacterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, ModelMapper modelMapper) {
        this.characterRepository = characterRepository;
        this.modelMapper = modelMapper;
    }

    public List<CharacterDTO> getAllCharacters() {
        return characterRepository.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
    }

    public CharacterDTO searchById(Long id) {
        return mapDTO(characterRepository.findById(id).get());
    }

    public CharacterDTO searchByName(String name){
        return mapDTO(characterRepository.findByName(name));
    }

    public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
        return mapDTO(characterRepository.save(mapEntity(characterDTO)));
    }

    public CharacterDTO updateCharacter(CharacterDTO characterDTO, Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));
        character.setName(!characterDTO.getName().isEmpty() ? characterDTO.getName() : character.getName());
        character.setGender(!characterDTO.getGender().isEmpty() ? characterDTO.getGender() : character.getGender());
        return mapDTO(characterRepository.save(character));
    }

    public void deleteCharacter(Long id) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));
        characterRepository.delete(character);
    }

    private Character mapEntity(CharacterDTO characterDTO) {
        return modelMapper.map(characterDTO, Character.class);
    }

    private CharacterDTO mapDTO(Character character) {
        if(character == null){
            return null;
        }
        return modelMapper.map(character, CharacterDTO.class);
    }
}

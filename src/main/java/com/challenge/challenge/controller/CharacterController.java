package com.challenge.challenge.controller;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(characterService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> saveCharacter(@RequestBody CharacterDTO characterDTO) {
        return ResponseEntity.ok(characterService.saveCharacter(characterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@RequestBody CharacterDTO characterDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(characterService.updateCharacter(characterDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.ok("Character Delete");
    }
}

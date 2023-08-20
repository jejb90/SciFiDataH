package com.challenge.challenge.controller;

import com.challenge.challenge.dto.CharacterDTO;
import com.challenge.challenge.service.CharacterService;
import com.challenge.challenge.service.ImageService;
import com.challenge.challenge.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private final CharacterService characterService;
    private final ImageService imageService;

    private final LocationService locationService;

    @Autowired
    public CharacterController(CharacterService characterService, ImageService imageService, LocationService locationService) {
        this.characterService = characterService;
        this.imageService = imageService;
        this.locationService = locationService;
    }

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
        return ResponseEntity.ok(characterService.getAllCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(characterService.searchById(id));
    }
    @PostMapping(consumes = {"multipart/form-data", "application/octet-stream"})
    public ResponseEntity<CharacterDTO> saveCharacter(
            @RequestParam String name,
            @RequestParam String species,
            @RequestParam String gender,
            @RequestParam String locationId,
            @RequestParam MultipartFile file
    ) {
        try{
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setName(name);
            characterDTO.setSpecies(species);
            characterDTO.setGender(gender);
            characterDTO.setLocation(locationService.searchById(Long.parseLong(locationId)));
            characterDTO.setImage(imageService.saveImage(file));

            return ResponseEntity.ok(characterService.saveCharacter(characterDTO));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

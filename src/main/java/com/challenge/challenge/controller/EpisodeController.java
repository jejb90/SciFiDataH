package com.challenge.challenge.controller;

import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.service.EpisodeService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/episode")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodes(){
        return ResponseEntity.ok(episodeService.getAllEpisodes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO>getEpisodeById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(episodeService.searchById(id));
    }

    @PostMapping
    public ResponseEntity<EpisodeDTO> saveEpisode(@RequestBody EpisodeDTO episodeDTO){
        List<Long> characters = episodeDTO.getCharacters().stream()
                .map(character -> character.getCharacter().getId())
                .collect(Collectors.toList());
        return ResponseEntity.ok(episodeService.saveEpisode(episodeDTO, characters));
    }

}

package com.challenge.challenge.controller;

import com.challenge.challenge.dto.EpisodeDTO;
import com.challenge.challenge.service.EpisodeService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<EpisodeDTO> saveEpisode(
            @RequestParam String name,
            @RequestParam String numberEpisode,
            @RequestParam List<Long> characters
    ){
        EpisodeDTO episodeDTO = new EpisodeDTO();
        episodeDTO.setName(name);
        episodeDTO.setNumberEpisode(numberEpisode);
        return ResponseEntity.ok(episodeService.saveEpisode(episodeDTO, characters));
    }

}

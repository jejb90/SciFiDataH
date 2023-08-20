package com.challenge.challenge.controller;


import com.challenge.challenge.dto.EpisodeWithDetails;
import com.challenge.challenge.service.RickAndMortyApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rickandmorty")
public class RickAndMortyApiController {

    private final RickAndMortyApiService rickAndMortyApiService;

    public RickAndMortyApiController(RickAndMortyApiService rickAndMortyApiService){
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping
    public EpisodeWithDetails getEpisode(@RequestParam(name = "episode") int episode) {
        return this.rickAndMortyApiService.getEpisodeDetails(episode);
     }
}

package com.challenge.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class EpisodeWithDetails {

    private int id;
    private String name;
    private String episode;
    private List<CharacterWithLocation> characters;

    public EpisodeWithDetails(int id, String name, String episode, List<CharacterWithLocation> characters) {
        this.id = id;
        this.name = name;
        this.episode = episode;
        this.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<CharacterWithLocation> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterWithLocation> characters) {
        this.characters = characters;
    }
}
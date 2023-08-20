package com.challenge.challenge.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeWithDetails {

    private int id;
    private String name;
    private String episode;
    private List<CharacterWithLocation> characters;
}
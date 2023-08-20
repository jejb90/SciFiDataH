package com.challenge.challenge.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeApi {

    private int id;
    private String name;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}

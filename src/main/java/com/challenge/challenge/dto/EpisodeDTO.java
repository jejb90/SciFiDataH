package com.challenge.challenge.dto;

import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {
    private Long id;

    private String name;

    private String numberEpisode;

    private List<EpisodeCharacterDTO> characters;
}

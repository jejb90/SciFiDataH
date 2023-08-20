package com.challenge.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeCharacterDTO {

    private long id;

    @JsonIgnore
    private EpisodeDTO episode;

    private CharacterDTO character;
}

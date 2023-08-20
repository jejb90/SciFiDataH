package com.challenge.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterWithLocation {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private LocationWithCharacter location;
    private String image;
}

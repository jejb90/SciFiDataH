package com.challenge.challenge.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {
    private Long id;
    private String name;
    private String species;
    private String gender;
    private String image;
    private LocationDTO location;
}

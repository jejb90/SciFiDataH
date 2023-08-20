package com.challenge.challenge.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterApi {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String url;
    private String image;

    private LocationApi location;
}

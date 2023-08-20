package com.challenge.challenge.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile file;

    private LocationDTO location;
}

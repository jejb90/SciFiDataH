package com.challenge.challenge.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "characters",uniqueConstraints = { @UniqueConstraint(columnNames = { "name" })})
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species", nullable = true)
    private String species;
    @Column(name = "gender", nullable = true)
    private String gender;

    @Column(name = "image", nullable = true)
    @Nullable
    private String image;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = true)
    private Location location;
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EpisodeCharacter> episodes;
}

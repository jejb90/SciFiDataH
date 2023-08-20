package com.challenge.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episodes",uniqueConstraints = { @UniqueConstraint(columnNames = { "number_episode" })})
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "number_episode", nullable = false)
    private String numberEpisode;

    @OneToMany(mappedBy = "episode")
    private List<EpisodeCharacter> characters;

}

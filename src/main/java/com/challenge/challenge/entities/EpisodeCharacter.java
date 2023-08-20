package com.challenge.challenge.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episode_character", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "episode_id", "character_id" })
})
public class EpisodeCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="episode_id", nullable = false)
    private Episode episode;
    @ManyToOne
    @JoinColumn(name="character_id", nullable = false)
    private Character character;

}

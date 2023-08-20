package com.challenge.challenge.repository;

import com.challenge.challenge.entities.EpisodeCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeCharacterRepository extends JpaRepository<EpisodeCharacter, Long> {

}

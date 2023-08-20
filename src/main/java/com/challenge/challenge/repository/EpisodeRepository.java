package com.challenge.challenge.repository;

import com.challenge.challenge.entities.Episode;
import com.challenge.challenge.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

}

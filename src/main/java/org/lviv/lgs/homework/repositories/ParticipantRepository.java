package org.lviv.lgs.homework.repositories;

import org.lviv.lgs.homework.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    @Query("SELECT p.coverId FROM Participant p WHERE p.id = :id")
    Optional<String> getCoverIdByParticipantId(@Param("id") int id);
}

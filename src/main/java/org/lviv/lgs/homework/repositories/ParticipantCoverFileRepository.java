package org.lviv.lgs.homework.repositories;

import org.lviv.lgs.homework.entities.ParticipantCoverFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantCoverFileRepository extends JpaRepository<ParticipantCoverFile, String> {

}

package org.lviv.lgs.homework.services;

import org.lviv.lgs.homework.entities.Participant;
import org.lviv.lgs.homework.repositories.ParticipantCoverFileRepository;
import org.lviv.lgs.homework.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private ParticipantRepository participantRepository;
    private final ParticipantCoverFileRepository participantCoverFileRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, ParticipantCoverFileRepository participantCoverFileRepository) {
        this.participantRepository = participantRepository;
        this.participantCoverFileRepository = participantCoverFileRepository;
    }

    public Optional<Participant> save(Participant participant){
        return Optional.of(participantRepository.save(participant));
    }

    public Participant findById(int id){
        Optional<Participant> participantMaybe = participantRepository.findById(id);

        if (participantMaybe.isPresent()){
            return participantMaybe.get();
        } else {
            String message = String.format("Can't find participant with id = %d", id);
            throw new RuntimeException(message);
        }
    }

    public List<Participant> findAll(){
        return participantRepository.findAll();
    }

    public void deleteById(int id){
        participantRepository.getCoverIdByParticipantId(id).ifPresent(participantCoverFileRepository::deleteById);
        participantRepository.deleteById(id);
    }
}

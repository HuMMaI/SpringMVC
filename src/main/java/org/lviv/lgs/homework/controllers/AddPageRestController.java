package org.lviv.lgs.homework.controllers;

import org.lviv.lgs.homework.entities.Participant;
import org.lviv.lgs.homework.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class AddPageRestController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/api/add")
    public void addParticipant(@ModelAttribute Participant participant, HttpServletResponse responce){
        if (participant.getCoverId().equals("")){
            participant.setCoverId(null);
        }

        Optional<Participant> save = participantService.save(participant);

        if (save.isPresent()){
            responce.setStatus(HttpServletResponse.SC_OK);
        }
    }
}

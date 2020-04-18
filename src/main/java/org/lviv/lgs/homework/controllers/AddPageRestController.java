package org.lviv.lgs.homework.controllers;

import org.lviv.lgs.homework.Participant;
import org.lviv.lgs.homework.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddPageRestController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/api/add")
    public void addParticipant(@ModelAttribute Participant participant){
        participantService.save(participant);
    }
}

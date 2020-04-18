package org.lviv.lgs.homework.controllers;

import org.lviv.lgs.homework.Participant;
import org.lviv.lgs.homework.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeRestController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/home")
    public List<Participant> getParticipants(){
        return participantService.findAll();
    }

    @GetMapping("/update")
    public Participant getParticipant(@RequestParam int id){
        return participantService.findById(id);
    }

    @PostMapping("/save-update")
    public void update(@ModelAttribute Participant participant){
        participantService.save(participant);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id){
        participantService.deleteById(id);
    }
}

package org.lviv.lgs.homework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/update")
    public String participantEdit(){
        return "participant_edit_page";
    }
}

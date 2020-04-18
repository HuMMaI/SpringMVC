package org.lviv.lgs.homework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddPageController {
    @GetMapping("/add")
    public String add(){
        return "add_page";
    }
}

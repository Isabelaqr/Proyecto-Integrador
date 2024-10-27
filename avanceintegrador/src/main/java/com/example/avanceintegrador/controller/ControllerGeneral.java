package com.example.avanceintegrador.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGeneral {

    @GetMapping("/index")
    public String mostrarIndex() {
        return "index";
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros() {
        return "nosotros";
    }
}

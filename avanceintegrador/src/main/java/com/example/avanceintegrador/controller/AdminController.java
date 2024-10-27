package com.example.avanceintegrador.controller;

import com.example.avanceintegrador.entidad.Admin;
import com.example.avanceintegrador.servicio.AdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {
    @Autowired
    private AdminServicio adminServicio;


    @GetMapping("/loginadmin")
    public String mostrarLoginAdmin() {
        return "loginadmin";
    }

    @PostMapping("/loginadmin/submit")
    public String procesarLoginAdmin(Admin admin, Model model) {
        Admin adminExistente = adminServicio.buscarPorUsuario(admin.getUsuario());
        if (adminExistente != null && adminExistente.getContraseña().equals(admin.getContraseña())) {
            return "redirect:/registrocliente";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Intenta de nuevo.");
            return "loginadmin";
        }
    }



}

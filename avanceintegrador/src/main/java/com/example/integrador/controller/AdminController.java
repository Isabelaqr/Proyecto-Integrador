package com.example.integrador.controller;

import com.example.integrador.servicio.AdminServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final AdminServicio adminServicio;

    @Autowired
    public AdminController(AdminServicio adminServicio) {
        this.adminServicio = adminServicio;
    }


    @GetMapping("/loginadmin")
    public String mostrarLoginAdmin() {
        logger.info("Acceso a la página de Login de Administrador");
        return "loginadmin";
    }

    @GetMapping("/register")
    public String mostrarFormularioRegistro() {
        logger.info("Acceso a la página de Registro de Administrador");
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(
            @RequestParam String name,
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password
    ) {
        logger.info("Registro de nuevo usuario: {}", username);
        adminServicio.registrarUsuario(name, username, email, password, "USER");
        logger.info("Usuario registrado con éxito: {}", username);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Obtener el nombre de usuario del usuario autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        logger.info("Acceso a la página de Administrador por el usuario: {}", username);

        // Pasar el nombre de usuario al modelo
        model.addAttribute("username", username);

        return "admin";  // Nombre de la vista (admin.html)
    }


}

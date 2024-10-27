package com.example.avanceintegrador.controller;


import com.example.avanceintegrador.entidad.UsuarioCliente;
import com.example.avanceintegrador.servicio.UsuarioClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioClienteController {
    @Autowired
    private UsuarioClienteServicio usuarioclienteServicio;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login/submit")
    public String procesarLogin(UsuarioCliente usuarioCliente, Model model) {
        UsuarioCliente clienteExistente = usuarioclienteServicio.buscarPorEmail(usuarioCliente.getEmail());
        if (clienteExistente != null && clienteExistente.getContraseña_cliente().equals(usuarioCliente.getContraseña_cliente())) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Intenta de nuevo.");
            return "login";
        }
    }

    @GetMapping("/registrocliente")
    public String mostrarRegistro(Model model) {
        model.addAttribute("usuarioCliente", new UsuarioCliente());
        return "registrocliente";
    }


    @PostMapping("/registrocliente/guardar")
    public String guardarCliente(UsuarioCliente usuarioCliente) {
        usuarioclienteServicio.registrarUsuarioCliente(usuarioCliente);
        return "redirect:/login";
    }




}

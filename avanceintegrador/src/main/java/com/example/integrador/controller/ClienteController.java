package com.example.integrador.controller;


import com.example.integrador.entidad.Cliente;
import com.example.integrador.servicio.ClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/login")
    public String mostrarFormularioDeLogin() {
        logger.info("Acceso a la página de Login de Cliente");
        return "login";
    }

    @PostMapping("/login/submit")
    public String procesarLogin(Cliente cliente, Model model) {
        Cliente clienteExistente = clienteServicio.buscarPorEmail(cliente.getEmail());

        if (clienteExistente != null && clienteExistente.getContraseña_cliente().equals(cliente.getContraseña_cliente())) {
            logger.info("Cliente autenticado con éxito: {}", cliente.getEmail());
            return "redirect:/iniciocliente";
        } else {
            logger.warn("Intento fallido de login para el cliente: {}", cliente.getEmail());
            model.addAttribute("error", "Credenciales incorrectas. Intenta de nuevo.");
            return "login"; // Regresar a la página de login
        }
    }

    // Mostrar el formulario para registrar un nuevo cliente
    @GetMapping("/registrocliente")
    public String mostrarFormularioDeRegistro(Model model) {
        logger.info("Acceso a la página de Registro de Cliente");
        model.addAttribute("cliente", new Cliente());
        return "registrocliente";
    }

    @PostMapping("/registrocliente/guardar")
    public String guardarCliente(Cliente cliente) {
        try {
            logger.info("Nuevo registro de cliente: {}", cliente.getEmail());
            clienteServicio.registrarCliente(cliente);
        } catch (Exception e) {
            logger.error("Error al registrar al cliente: {}", cliente.getEmail(), e);
            return "error"; // Podrías redirigir a una página de error si es necesario
        }
        return "redirect:/login";
    }

    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        logger.info("Acceso a la lista de clientes");
        List<Cliente> listaClientes = clienteServicio.obtenerClientes();
        model.addAttribute("clientes", listaClientes);
        return "cliente"; // Nombre del archivo HTML
    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        logger.info("Eliminación de cliente con ID: {}", id);
        clienteServicio.eliminarCliente(id);
        return "redirect:/admin";
    }

}

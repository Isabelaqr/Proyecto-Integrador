package com.example.integrador.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerGeneral {
    private static final Logger logger = LoggerFactory.getLogger(ControllerGeneral.class);

    @GetMapping("/index")
    public String mostrarIndex() {
        logger.info("Acceso a la página de Index");
        return "index";
    }

    @GetMapping("/tienda")
    public String mostrarTienda() {
        logger.info("Acceso a la página de Tienda");
        return "tienda";
    }

    @GetMapping("/terminosycondiciones")
    public String mostrarTerminosycondiciones() {
        logger.info("Acceso a la página de Términos y Condiciones");
        return "terminosycondiciones";
    }

    @GetMapping("/privacidad")
    public String mostrarPrivacidad() {
        logger.info("Acceso a la página de Privacidad");
        return "privacidad";
    }

    @GetMapping("/preguntas")
    public String mostrarPreguntas() {
        logger.info("Acceso a la página de Preguntas Frecuentes");
        return "preguntas";
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros() {
        logger.info("Acceso a la página de Nosotros");
        return "nosotros";
    }

    @GetMapping("/carrito")
    public String mostrarCarrito() {
        logger.info("Acceso a la página de Carrito");
        return "carrito";
    }

    @GetMapping("/anuncios")
    public String mostrarAnuncios() {
        logger.info("Acceso a la página de Anuncios");
        return "anuncios";
    }

    @GetMapping("/iniciocliente")
    public String mostrarInicioCliente() {
        logger.info("Acceso a la página de Inicio Cliente");
        return "iniciocliente";
    }

    @GetMapping("/graficos")
    public String mostrarGrafico() {
        logger.info("Acceso a la página de Gráficos");
        return "graficos";
    }

    @GetMapping("/boleta")
    public String mostrarBoleta() {
        logger.info("Acceso a la página de Boleta");
        return "boleta";
    }

}

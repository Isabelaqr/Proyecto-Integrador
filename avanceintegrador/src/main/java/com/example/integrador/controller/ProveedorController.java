package com.example.integrador.controller;


import com.example.integrador.entidad.Proveedor;
import com.example.integrador.servicio.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProveedorController {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @GetMapping("/proveedores")
    public String mostrarFormularioYProveedores(Model model) {

        List<Proveedor> proveedores = proveedorServicio.obtenerProveedores();

        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedores);

        return "proveedor";
    }

    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(Proveedor proveedor, RedirectAttributes redirectAttributes) {
        proveedorServicio.guardarProveedor(proveedor);  // Guardar en la base de datos
        // Añadir un mensaje de éxito a los atributos de redirección
        redirectAttributes.addFlashAttribute("mensaje", "Proveedor añadido exitosamente");
        return "redirect:/admin";  // Redirigir a la misma página para agregar otro producto
    }


    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            proveedorServicio.eliminarProveedor(id);
            redirectAttributes.addFlashAttribute("mensaje", "Proveedor eliminado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el proveedor.");
        }
        return "redirect:/admin";
    }
}

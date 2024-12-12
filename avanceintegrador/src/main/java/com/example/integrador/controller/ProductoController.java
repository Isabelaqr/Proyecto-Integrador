package com.example.integrador.controller;


import com.example.integrador.entidad.Producto;
import com.example.integrador.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductoServicio productoServicio;

    // Procesar el formulario y guardar el producto en la base de datos
    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, RedirectAttributes redirectAttributes) {
        productoServicio.guardarProducto(producto);  // Guardar en la base de datos
        // Añadir un mensaje de éxito a los atributos de redirección
        redirectAttributes.addFlashAttribute("mensaje", "Producto guardado exitosamente");
        return "redirect:/admin";  // Redirigir a la misma página para agregar otro producto
    }

    @GetMapping("/productos")
    public String mostrarFormularioYProductos(Model model) {
        // Obtener todos los productos desde la base de datos
        List<Producto> productos = productoServicio.obtenerProductos();

        // Añadir el formulario y la lista de productos al modelo
        model.addAttribute("producto", new Producto()); // Objeto vacío para el formulario
        model.addAttribute("productos", productos);     // Lista de productos

        return "producto"; // El nombre del archivo HTML
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            productoServicio.eliminarProducto(id);
            redirectAttributes.addFlashAttribute("mensaje", "Producto eliminado con éxito.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el producto.");
        }
        return "redirect:/admin"; // Redirige a la vista de productos
    }

}

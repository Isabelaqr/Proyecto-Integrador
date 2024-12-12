package com.example.integrador.servicio;


import com.example.integrador.entidad.Producto;
import com.example.integrador.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> obtenerProductos() {
        return productoRepositorio.findAll();
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    public void eliminarProducto(Long id) {
        productoRepositorio.deleteById(id);
    }

}

package com.example.integrador.servicio;


import com.example.integrador.entidad.Proveedor;
import com.example.integrador.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    public List<Proveedor> obtenerProveedores() {
        return proveedorRepositorio.findAll();
    }

    public Proveedor obtenerProveedorPorId(Long id) {
        return proveedorRepositorio.findById(id).orElse(null);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
    }
}

package com.example.integrador.repositorio;


import com.example.integrador.entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
}

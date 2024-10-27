package com.example.avanceintegrador.servicio;


import com.example.avanceintegrador.entidad.UsuarioCliente;
import com.example.avanceintegrador.repositorio.UsuarioClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioClienteServicio {
    @Autowired
    private UsuarioClienteRepositorio usuarioClienteRepositorio;

    public UsuarioCliente registrarUsuarioCliente(UsuarioCliente usuarioCliente) {
        return usuarioClienteRepositorio.save(usuarioCliente);
    }

    public UsuarioCliente buscarPorEmail(String email) {
        return usuarioClienteRepositorio.findByEmail(email);
    }

}

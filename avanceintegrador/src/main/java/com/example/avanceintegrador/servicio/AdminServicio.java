package com.example.avanceintegrador.servicio;


import com.example.avanceintegrador.entidad.Admin;
import com.example.avanceintegrador.repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicio {

    @Autowired
    private AdminRepositorio adminRepositorio;

    public Admin registrarUsuario(Admin admin) {
        return adminRepositorio.save(admin);
    }

    public Admin buscarPorUsuario(String usuario) {
        return adminRepositorio.findByUsuario(usuario);
    }

}

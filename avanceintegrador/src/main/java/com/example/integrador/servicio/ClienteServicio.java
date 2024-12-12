package com.example.integrador.servicio;


import com.example.integrador.entidad.Cliente;
import com.example.integrador.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepositorio.findByEmail(email); // Debes implementar este método en tu repositorio
    }
    public List<Cliente> obtenerClientes() {
        return clienteRepositorio.findAll();
    }
    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }

}


package com.example.hora_vital_api.service;

import com.example.hora_vital_api.model.Usuario;
import com.example.hora_vital_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCorreoElectronico(usuario.getCorreoElectronico())) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        if (usuarioRepository.existsByRut(usuario.getRut())) {
            throw new IllegalArgumentException("El RUT ya está registrado.");
        }


        return usuarioRepository.save(usuario);
    }
}
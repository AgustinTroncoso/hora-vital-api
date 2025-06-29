
package com.example.hora_vital_api.service;

import com.example.hora_vital_api.model.Usuario;
import com.example.hora_vital_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario registrarUsuario(Usuario usuarioInput) {
        if (usuarioRepository.existsByCorreoElectronico(usuarioInput.getCorreoElectronico())) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        if (usuarioRepository.existsByRut(usuarioInput.getRut())) {
            throw new IllegalArgumentException("El RUT ya está registrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setRut(usuarioInput.getRut());
        usuario.setNombreCompleto(usuarioInput.getNombreCompleto());
        usuario.setDireccion(usuarioInput.getDireccion());
        usuario.setCorreoElectronico(usuarioInput.getCorreoElectronico());
        usuario.setTelefono(usuarioInput.getTelefono());
        usuario.setAseguradora(usuarioInput.getAseguradora());
        usuario.setFechaNacimiento(usuarioInput.getFechaNacimiento());
        usuario.setContrasena(usuarioInput.getContrasena());

        return usuarioRepository.save(usuario);
    }
}
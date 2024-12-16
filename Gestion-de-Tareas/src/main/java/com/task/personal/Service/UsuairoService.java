package com.task.personal.Service;

import com.task.personal.Entity.UsuarioEntity;
import com.task.personal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuairoService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear o actualizar un usuario
    public UsuarioEntity saveUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener un usuario por ID
    public Optional<UsuarioEntity> getUsuarioById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    // Obtener todos los usuarios
    public List<UsuarioEntity> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Eliminar un usuario por ID
    public void deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

}

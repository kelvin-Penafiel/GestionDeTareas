package com.task.personal.Controller;

import com.task.personal.Entity.UsuarioEntity;
import com.task.personal.Service.UsuairoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuairoService usuarioService;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UsuarioEntity> createUsuario(@RequestBody UsuarioEntity usuario) {
        return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
    }

    // Obtener un usuario por ID
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Long idUsuario) {
        Optional<UsuarioEntity> usuario = usuarioService.getUsuarioById(idUsuario);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    // Actualizar un usuario existente
    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioEntity> updateUsuario(@PathVariable Long idUsuario, @RequestBody UsuarioEntity usuario) {
        Optional<UsuarioEntity> existingUsuario = usuarioService.getUsuarioById(idUsuario);
        if (existingUsuario.isPresent()) {
            usuario.setIdUsuario(idUsuario);
            return ResponseEntity.ok(usuarioService.saveUsuario(usuario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long idUsuario) {
        usuarioService.deleteUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}

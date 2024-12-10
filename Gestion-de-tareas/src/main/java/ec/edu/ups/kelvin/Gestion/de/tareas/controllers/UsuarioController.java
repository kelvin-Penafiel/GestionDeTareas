package ec.edu.ups.kelvin.Gestion.de.tareas.controllers;

import ec.edu.ups.kelvin.Gestion.de.tareas.entities.Usuario;
import ec.edu.ups.kelvin.Gestion.de.tareas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Crear un nuevo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    // Actualizar un usuario
    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuario.setIdentificacion(usuarioDetalles.getIdentificacion());
        usuario.setNombres(usuarioDetalles.getNombres());
        usuario.setApellidos(usuarioDetalles.getApellidos());
        usuario.setEdad(usuarioDetalles.getEdad());
        usuario.setCargo(usuarioDetalles.getCargo());
        usuario.setEstado(usuarioDetalles.getEstado());

        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado con ID: " + id;
    }
}

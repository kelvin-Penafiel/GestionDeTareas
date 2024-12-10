package ec.edu.ups.kelvin.Gestion.de.tareas.repositories;

import ec.edu.ups.kelvin.Gestion.de.tareas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para manejar las operaciones CRUD de Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
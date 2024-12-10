package ec.edu.ups.kelvin.Gestion.de.tareas.repositories;

import ec.edu.ups.kelvin.Gestion.de.tareas.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
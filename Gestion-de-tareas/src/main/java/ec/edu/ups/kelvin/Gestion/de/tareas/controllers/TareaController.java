package ec.edu.ups.kelvin.Gestion.de.tareas.controllers;

import ec.edu.ups.kelvin.Gestion.de.tareas.entities.Tarea;
import ec.edu.ups.kelvin.Gestion.de.tareas.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    // Obtener todas las tareas
    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    // Crear una nueva tarea
    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public Tarea updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetalles) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        tarea.setCodigoTarea(tareaDetalles.getCodigoTarea());
        tarea.setTituloTarea(tareaDetalles.getTituloTarea());
        tarea.setDescripcion(tareaDetalles.getDescripcion());
        tarea.setCriteriosAceptacion(tareaDetalles.getCriteriosAceptacion());
        tarea.setFechaInicio(tareaDetalles.getFechaInicio());
        tarea.setFechaFinalizacion(tareaDetalles.getFechaFinalizacion());
        tarea.setTiempoDesarrollo(tareaDetalles.getTiempoDesarrollo());
        tarea.setEstadoTarea(tareaDetalles.getEstadoTarea());

        return tareaRepository.save(tarea);
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public String deleteTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
        return "Tarea eliminada con ID: " + id;
    }
}
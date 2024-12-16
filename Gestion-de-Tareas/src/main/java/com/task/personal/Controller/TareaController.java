package com.task.personal.Controller;
import com.task.personal.Entity.TareaEntity;
import com.task.personal.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Crear una nueva tarea
    @PostMapping
    public ResponseEntity<TareaEntity> createTarea(@RequestBody TareaEntity tarea) {
        return ResponseEntity.ok(tareaService.saveTarea(tarea));
    }

    // Obtener una tarea por ID
    @GetMapping("/{idTarea}")
    public ResponseEntity<TareaEntity> getTareaById(@PathVariable Long idTarea) {
        Optional<TareaEntity> tarea = tareaService.getTareaById(idTarea);
        return tarea.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<TareaEntity>> getAllTareas() {
        return ResponseEntity.ok(tareaService.getAllTareas());
    }

    // Actualizar una tarea existente
    @PutMapping("/{idTarea}")
    public ResponseEntity<TareaEntity> updateTarea(@PathVariable Long idTarea, @RequestBody TareaEntity tarea) {
        Optional<TareaEntity> existingTarea = tareaService.getTareaById(idTarea);
        if (existingTarea.isPresent()) {
            tarea.setIdTarea(idTarea);
            return ResponseEntity.ok(tareaService.saveTarea(tarea));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una tarea por ID
    @DeleteMapping("/{idTarea}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long idTarea) {
        tareaService.deleteTarea(idTarea);
        return ResponseEntity.noContent().build();
    }

    // Actualizar el estado de una tarea
    @PatchMapping("/{idTarea}/estado")
    public ResponseEntity<TareaEntity> updateEstadoTarea(@PathVariable Long idTarea, @RequestParam TareaEntity.EstadoTarea nuevoEstado) {
        Optional<TareaEntity> tarea = tareaService.updateEstadoTarea(idTarea, nuevoEstado);
        return tarea.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
package com.task.personal.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tareas")
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;

    @Column(nullable = false, unique = true)
    private String codigoTarea;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 1000)
    private String criteriosAceptacion;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFinalizacion;

    @Column(nullable = false)
    private String tiempoDesarrollo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTarea estadoTarea;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;



    public enum EstadoTarea {
        Backlog,
        Doing,
        InReview,
        Done;
    }

}
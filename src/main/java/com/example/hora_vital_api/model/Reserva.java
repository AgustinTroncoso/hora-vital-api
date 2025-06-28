package com.example.hora_vital_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombrePaciente;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 12)
    private String rut;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false)
    private String numeroContacto;

    @Column(nullable = false)
    private String causa;

    @Column(nullable = false)
    private LocalDate fechaConsulta;

    @Column(nullable = false)
    private String medico;

    @Column(nullable = false)
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
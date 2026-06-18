package com.mayorista.notificacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notificaciones")
@Data
public class notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinatario;
    private String mensaje;
    private String fecha; // Para saber cuándo se envió
}
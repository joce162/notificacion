package com.mayorista.notificacion.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DespachoDTO {
    private Long idDespacho;
    private Long idPedido;
    private String EstadoDespacho;
    private LocalDateTime fechaEntrega;
}

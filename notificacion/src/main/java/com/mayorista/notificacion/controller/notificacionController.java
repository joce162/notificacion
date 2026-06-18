package com.mayorista.notificacion.controller;

import com.mayorista.notificacion.model.notificacion;
import com.mayorista.notificacion.service.notificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class notificacionController {

    @Autowired
    private notificacionService servicio;
    @PostMapping("/generar/{idDespacho}")
    public ResponseEntity<?> generarNotificacion(@PathVariable Long idDespacho) {
        try {
            notificacion nuevaNotificacion = servicio.generarNotificacionDeEnvio(idDespacho);
            return new ResponseEntity<>(nuevaNotificacion, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
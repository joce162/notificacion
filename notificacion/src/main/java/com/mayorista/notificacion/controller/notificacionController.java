package com.mayorista.notificacion.controller;

import com.mayorista.notificacion.model.notificacion;
import com.mayorista.notificacion.service.notificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class notificacionController {

    @Autowired
    private notificacionService service;

    @GetMapping
    public List<notificacion> listar() {
        return service.obtenerTodas();
    }

    @PostMapping
    public ResponseEntity<notificacion> enviar(@RequestBody notificacion n) {
        notificacion nueva = service.guardarNotificacion(n);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }
}
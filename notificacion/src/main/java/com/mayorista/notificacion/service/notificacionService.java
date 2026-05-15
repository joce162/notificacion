package com.mayorista.notificacion.service;

import com.mayorista.notificacion.model.notificacion;
import com.mayorista.notificacion.repository.notificacionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class notificacionService {

    private static final Logger logger = LoggerFactory.getLogger(notificacionService.class);

    @Autowired
    private notificacionRepository repository;

    public List<notificacion> obtenerTodas() {
        return repository.findAll();
    }

    public notificacion guardarNotificacion(notificacion n) {
        n.setFecha(LocalDateTime.now().toString());

        logger.info("LOG: Enviando notificación para el destinatario: {}", n.getDestinatario());

        return repository.save(n);
    }
}
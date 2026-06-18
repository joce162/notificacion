package com.mayorista.notificacion.service;

import com.mayorista.notificacion.Dto.DespachoDTO;
import com.mayorista.notificacion.client.LogisticaClient;
import com.mayorista.notificacion.model.notificacion;
import com.mayorista.notificacion.repository.notificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class notificacionService {

    @Autowired
    private notificacionRepository repository;

    @Autowired
    private LogisticaClient logisticaClient; // 👈 Inyección del componente desacoplado

    public notificacion generarNotificacionDeEnvio(Long idDespacho) {
        DespachoDTO datosEnvio = logisticaClient.obtenerDatosDespacho(idDespacho);

        if (datosEnvio == null) {
            throw new RuntimeException("No se encontró el despacho :C");
        }

        notificacion nueva = new notificacion();
        nueva.setDestinatario("cliente_pedido_" + datosEnvio.getIdPedido() + "@mayorista.com");

        nueva.setMensaje("Hola! tu pedido N° " + datosEnvio.getIdPedido() +
                " tiene un nuevo estado: " + datosEnvio.getEstadoDespacho() +
                ". la fecha de entrega programada es: " + datosEnvio.getFechaEntrega());

        nueva.setFecha(LocalDateTime.now().toString());

        return repository.save(nueva);
    }
}
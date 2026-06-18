package com.mayorista.notificacion.client;

import com.mayorista.notificacion.Dto.DespachoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LogisticaClient {

    private final String ENVIOS_URL = "http://localhost:8086/api/v1/logistica";
    private final WebClient webClient = WebClient.create();

    public DespachoDTO obtenerDatosDespacho(Long idDespacho) {
        try {
            return webClient.get()
                    .uri(ENVIOS_URL + "/" + idDespacho)
                    .retrieve()
                    .bodyToMono(DespachoDTO.class)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar de forma remota con Logística: " + e.getMessage());
        }
    }
}
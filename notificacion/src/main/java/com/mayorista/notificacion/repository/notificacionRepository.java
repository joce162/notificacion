package com.mayorista.notificacion.repository;

import com.mayorista.notificacion.model.notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface notificacionRepository extends JpaRepository<notificacion, Long> {
}
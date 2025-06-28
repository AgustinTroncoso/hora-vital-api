package com.example.hora_vital_api.repository;

import com.example.hora_vital_api.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
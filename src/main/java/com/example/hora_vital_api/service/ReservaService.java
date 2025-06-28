package com.example.hora_vital_api.service;

import com.example.hora_vital_api.model.Reserva;
import com.example.hora_vital_api.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva crearReserva(Reserva reserva) {
        if (reserva.getUsuario() == null) {
            throw new IllegalArgumentException("El usuario es obligatorio para la reserva.");
        }


        return reservaRepository.save(reserva);
    }

    public List<Reserva> obtenerReservasPorUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }
}
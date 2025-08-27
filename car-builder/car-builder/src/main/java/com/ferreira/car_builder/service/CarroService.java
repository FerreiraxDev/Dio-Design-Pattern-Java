package com.ferreira.car_builder.service;

import com.ferreira.car_builder.dto.CarroRequestDTO;
import com.ferreira.car_builder.model.Carro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class CarroService {
    private final Map<Long, Carro> carrosDB = new ConcurrentHashMap<>();

    public Carro criarCarro(CarroRequestDTO dto) {
        Carro.CarroBuilder builder = new Carro.CarroBuilder(dto.getMotor(), dto.getRodas());

        if (dto.getCor() != null && !dto.getCor().isBlank()) {
            builder.comCor(dto.getCor());
        }
        if (dto.getTemGps() != null) {
            builder.comGps(dto.getTemGps());
        }
        if (dto.getTemTetoSolar() != null) {
            builder.comTetoSolar(dto.getTemTetoSolar());
        }
        if (dto.getTemSpoiler() != null) {
            builder.comSpoiler(dto.getTemSpoiler());
        }

        Carro novoCarro = builder.build();

        carrosDB.put(novoCarro.getId(), novoCarro);

        return novoCarro;
    }

    public List<Carro> listarTodos() {
        return new ArrayList<>(carrosDB.values());
    }
}

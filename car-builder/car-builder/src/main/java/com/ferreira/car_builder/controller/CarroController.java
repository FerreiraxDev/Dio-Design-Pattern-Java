package com.ferreira.car_builder.controller;

import com.ferreira.car_builder.dto.CarroRequestDTO;
import com.ferreira.car_builder.model.Carro;
import com.ferreira.car_builder.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Carro> criarCarro(@Valid @RequestBody CarroRequestDTO carroDTO) {
        Carro novoCarro = carroService.criarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarCarros() {
        List<Carro> carros = carroService.listarTodos();
        return ResponseEntity.ok(carros);
    }
}
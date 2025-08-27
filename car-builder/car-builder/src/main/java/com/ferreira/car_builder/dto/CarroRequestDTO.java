package com.ferreira.car_builder.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarroRequestDTO {
    @NotBlank(message = "O motor é obrigatório.")
    private String motor;

    @NotNull(message = "O número de rodas é obrigatório.")
    @Min(value = 2, message = "Um veículo deve ter pelo menos 2 rodas.")
    private Integer rodas;

    // Atributos opcionais não precisam de validação @NotBlank ou @NotNull
    private String cor;
    private Boolean temGps;
    private Boolean temTetoSolar;
    private Boolean temSpoiler;

    // Getters e Setters para o framework (Jackson) preencher o objeto a partir do JSON
    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getRodas() {
        return rodas;
    }

    public void setRodas(Integer rodas) {
        this.rodas = rodas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getTemGps() {
        return temGps;
    }

    public void setTemGps(Boolean temGps) {
        this.temGps = temGps;
    }

    public Boolean getTemTetoSolar() {
        return temTetoSolar;
    }

    public void setTemTetoSolar(Boolean temTetoSolar) {
        this.temTetoSolar = temTetoSolar;
    }

    public Boolean getTemSpoiler() {
        return temSpoiler;
    }

    public void setTemSpoiler(Boolean temSpoiler) {
        this.temSpoiler = temSpoiler;
    }
}

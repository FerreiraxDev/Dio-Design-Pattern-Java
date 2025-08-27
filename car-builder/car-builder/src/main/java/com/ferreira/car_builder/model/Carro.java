package com.ferreira.car_builder.model;
import java.util.concurrent.atomic.AtomicLong;

public class Carro {

    private static final AtomicLong counter = new AtomicLong();

    private final long id;
    private final String motor;
    private final int rodas;
    private final String cor;
    private final boolean temGps;
    private final boolean temTetoSolar;
    private final boolean temSpoiler;

    private Carro(CarroBuilder builder) {
        this.id = counter.incrementAndGet();
        this.motor = builder.motor;
        this.rodas = builder.rodas;
        this.cor = builder.cor;
        this.temGps = builder.temGps;
        this.temTetoSolar = builder.temTetoSolar;
        this.temSpoiler = builder.temSpoiler;
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getMotor() {
        return motor;
    }
    public int getRodas() {
        return rodas;
    }
    public String getCor() {
        return cor;
    }
    public boolean isTemGps() {
        return temGps;
    }
    public boolean isTemTetoSolar() {
        return temTetoSolar;
    }
    public boolean isTemSpoiler() {
        return temSpoiler;
    }

    @Override
    public String toString() {
        return "Carro[id=" + id + ", motor='" + motor + "', rodas=" + rodas + ", ...]";
    }

    // O Builder permanece o mesmo.
    public static class CarroBuilder {
        private final String motor;
        private final int rodas;
        private String cor = "Branco";
        private boolean temGps = false;
        private boolean temTetoSolar = false;
        private boolean temSpoiler = false;

        public CarroBuilder(String motor, int rodas) {
            this.motor = motor;
            this.rodas = rodas;
        }

        public CarroBuilder comCor(String cor) {
            this.cor = cor;
            return this;
        }
        public CarroBuilder comGps(boolean temGps) {
            this.temGps = temGps;
            return this;
        }
        public CarroBuilder comTetoSolar(boolean temTetoSolar) {
            this.temTetoSolar = temTetoSolar;
            return this;
        }
        public CarroBuilder comSpoiler(boolean temSpoiler) {
            this.temSpoiler = temSpoiler;
            return this;
        }
        public Carro build() {
            return new Carro(this);
        }
    }
}
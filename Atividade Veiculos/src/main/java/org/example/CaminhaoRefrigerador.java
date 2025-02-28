package org.example;

class CaminhaoRefrigerado extends Caminhao {
    private double temperaturaMinima;

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga, double temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularAutonomia() {
        return Math.max(super.calcularAutonomia() * 0.9, 0); // Redução de 10% devido à refrigeração
    }
}

package org.example;

class Onibus extends Veiculo {
    private int quantidadeEixos;

    public Onibus(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int quantidadeEixos) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        if (quantidadeEixos < 6 || quantidadeEixos > 8) {
            throw new IllegalArgumentException("Ônibus deve ter entre 6 a 8 eixos.");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    @Override
    public double calcularAutonomia() {
        return 200 * 5; // Tanque de 200 litros, consumo de 5 km/L
    }
}
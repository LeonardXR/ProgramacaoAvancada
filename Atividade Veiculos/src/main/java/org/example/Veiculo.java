package org.example;

abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected int capacidadePassageiros;
    protected String combustivel;

    public Veiculo(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.combustivel = combustivel;
    }

    public abstract double calcularAutonomia();

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Passageiros: " + capacidadePassageiros + ", Combustível: " + combustivel);
    }
}



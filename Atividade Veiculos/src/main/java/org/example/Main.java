package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 5, "Gasolina", "Sedan");
        Caminhao caminhao = new Caminhao("Volvo", "FH16", 2021, 2, "Diesel", 10);
        Onibus onibus = new Onibus("Mercedes", "Buss 500", 2023, 50, "Diesel", 6);
        CarroEletrico carroEletrico = new CarroEletrico("Tesla", "Model S", 2023, 5, "Elétrico", "Sedan", 100);
        CaminhaoRefrigerado caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R450", 2020, 2, "Diesel", 8, -10);

        System.out.println("Informaçoes do Carro: ");
        carro.exibirDetalhes();
        System.out.println("Autonomia:" + carro.calcularAutonomia() + " km");

        System.out.println("Informaçoes do Caminhao: ");
        caminhao.exibirDetalhes();
        System.out.println("Autonomia: " + caminhao.calcularAutonomia() + " km");

        System.out.println("Informaçoes do Onibus: ");
        onibus.exibirDetalhes();
        System.out.println("Autonomia: " + onibus.calcularAutonomia() + " km");

        System.out.println("Informaçoes do Carro eletrico: ");
        carroEletrico.exibirDetalhes();
        System.out.println("Autonomia: " + carroEletrico.calcularAutonomia() + " km");

        System.out.println("Informaçoes do Carro refrigerado: ");
        caminhaoRefrigerado.exibirDetalhes();
        System.out.println("Autonomia: " + caminhaoRefrigerado.calcularAutonomia() + " km");
    }
}
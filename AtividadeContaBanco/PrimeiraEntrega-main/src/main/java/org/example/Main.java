package org.example;

public class Main {
    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaCorrente("1001", "Carlos Silva", 3000, 1000);
        ContaBancaria contaPoupanca = new ContaPoupanca("1002", "Mariana Souza", 5000);
        ContaBancaria contaInvestimento = new ContaInvestimento("1003", "Ricardo Alves", 8000);
        ContaBancaria contaSalario = new ContaSalario("1004", "Ana Lima", 2000, 500);
        ContaBancaria contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco("1005", "Fernanda Costa", 15000);

        contaCorrente.depositar(500);
        contaPoupanca.depositar(1000);
        contaInvestimento.depositar(2000);

        contaCorrente.sacar(3500);
        contaPoupanca.sacar(4000);
        contaInvestimento.sacar(3000);
        contaSalario.sacar(500);
        contaSalario.sacar(500);
        contaInvestimentoAltoRisco.sacar(11000);

        System.out.println("\nInformações das Contas:\n");
        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();
        contaInvestimento.exibirInformacoes();
        contaSalario.exibirInformacoes();
        contaInvestimentoAltoRisco.exibirInformacoes();
    }
}


package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o método de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Boleto");

        int opcao = scanner.nextInt();

        System.out.print("Digite o valor da transação: ");
        double valor = scanner.nextDouble();

        EstrategiaPagamento estrategiaPagamento = null;
        switch (opcao) {
            case 1:
                estrategiaPagamento = new PagamentoPix();
                break;
            case 2:
                estrategiaPagamento = new PagamentoCartaoCredito();
                break;
            case 3:
                estrategiaPagamento = new PagamentoBoleto();
                break;
            default:
                System.out.println("Opção inválida.");
                System.exit(1);
        }

        ProcessadorPagamento processadorPagamento = new ProcessadorPagamento(estrategiaPagamento);
        processadorPagamento.processar(valor);

        scanner.close();
    }
}
package org.example;

import java.util.Scanner;

// Estratégia de pagamento via Cartão de Crédito.
public class PagamentoCartaoCredito implements EstrategiaPagamento {

    // Solicita o número do cartão e processa o pagamento.
    @Override
    public void processarPagamento(double valor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão de crédito (fictício): ");
        String numeroCartao = scanner.nextLine();
        System.out.println("Pagando R$" + valor + " via Cartão de Crédito.");
        System.out.println("Número do cartão: " + numeroCartao);
        System.out.println("Pagamento confirmado!");
    }
}

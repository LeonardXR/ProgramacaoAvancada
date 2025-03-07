package org.example;

import java.util.Scanner;

// Aplicativo que permite ao usuário selecionar o método de pagamento.
public class PaymentApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções de pagamento.
        System.out.println("Selecione o método de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Boleto");
        System.out.println("4. Transferência Bancária");

        // Captura a opção escolhida.
        int option = scanner.nextInt();

        // Solicita o valor da transação.
        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        // Cria a estratégia de pagamento.
        PaymentStrategy paymentStrategy = PaymentFactory.createPaymentMethod(option);

        // Processa o pagamento.
        PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
        processor.process(amount);

        scanner.close();
    }
}
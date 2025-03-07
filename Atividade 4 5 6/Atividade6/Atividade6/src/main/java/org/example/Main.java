package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Exibe as opções de pagamento
        System.out.println("Selecione o método de pagamento:");
        System.out.println("1. Pix");

        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Boleto");
        System.out.println("4. Transferência Bancária");

        // Coleta a escolha do usuário
        int option = scanner.nextInt();

        // Solicita o valor da transação
        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();

        // Cria a estratégia de pagamento usando o Factory Method
        PaymentStrategy paymentStrategy = PaymentFactory.createPaymentMethod(option);

        // Processa o pagamento usando a estratégia escolhida
        PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
        processor.process(amount);

        scanner.close();
    }
}
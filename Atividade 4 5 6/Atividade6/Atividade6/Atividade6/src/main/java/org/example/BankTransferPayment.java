package org.example;

// Estratégia de pagamento via transferência bancária.
public class BankTransferPayment implements PaymentStrategy {

    // Exibe mensagem de pagamento via transferência bancária.
    @Override
    public void processPayment(double amount) {
        System.out.println("Realizando transferência bancária de R$" + amount + ".");
    }
}

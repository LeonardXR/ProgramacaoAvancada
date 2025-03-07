package org.example;

// Estratégia de pagamento via Boleto.
public class BoletoPayment implements PaymentStrategy {

    // Exibe mensagem de geração de boleto.
    @Override
    public void processPayment(double amount) {
        System.out.println("Gerando boleto de R$" + amount + ".");
    }
}
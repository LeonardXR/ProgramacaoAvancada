package org.example;

// Estratégia de pagamento via Pix.
public class PixPayment implements PaymentStrategy {

    // Exibe mensagem de pagamento via Pix.
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagando R$" + amount + " via Pix.");
    }
}
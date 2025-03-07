package org.example;

// Estratégia de pagamento via Cartão de Crédito.
public class CreditCardPayment implements PaymentStrategy {

    // Exibe mensagem de pagamento via cartão de crédito.
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagando R$" + amount + " via Cartão de Crédito.");
    }
}
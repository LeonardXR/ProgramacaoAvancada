package org.example;

// Interface para estratégias de pagamento.
public interface PaymentStrategy {

    // Método para processar o pagamento.
    void processPayment(double amount);
}
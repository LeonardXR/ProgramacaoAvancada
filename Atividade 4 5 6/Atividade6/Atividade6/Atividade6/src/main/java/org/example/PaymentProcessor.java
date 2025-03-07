package org.example;

public class PaymentProcessor {
    
    private PaymentStrategy paymentStrategy;

    // Inicializa o processador com a estratégia de pagamento.
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Processa o pagamento.
    public void process(double amount) {
        paymentStrategy.processPayment(amount);
    }
}


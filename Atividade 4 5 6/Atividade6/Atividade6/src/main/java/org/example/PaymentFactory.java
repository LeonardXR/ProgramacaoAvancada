package org.example;

// Fábrica de estratégias de pagamento.
public class PaymentFactory {

    // Cria a estratégia de pagamento com base na opção.
    public static PaymentStrategy createPaymentMethod(int option) {
        switch (option) {
            case 1: return new PixPayment();
            case 2: return new CreditCardPayment();
            case 3: return new BoletoPayment();
            case 4: return new BankTransferPayment();
            default: throw new IllegalArgumentException("Opção de pagamento inválida!");
        }
    }
}


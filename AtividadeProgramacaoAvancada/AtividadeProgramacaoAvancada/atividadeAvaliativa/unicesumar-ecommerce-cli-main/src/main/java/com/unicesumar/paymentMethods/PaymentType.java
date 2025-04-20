package com.unicesumar.paymentMethods;

public enum PaymentType implements PaymentMethod {
    PIX, BOLETO, CARTAO;

    //Factory Pattern
    @Override
    public void pay(double amount) {
        switch (this) {
            case PIX:
                System.out.println("Pagamento via PIX: R$" + amount);
                break;
            case BOLETO:
                System.out.println("Pagamento via Boleto: R$" + amount);
                break;
            case CARTAO:
                System.out.println("Pagamento via Cartão: R$" + amount);
                break;
        }
    }

}
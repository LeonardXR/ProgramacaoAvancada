package org.example;

import java.util.Random;

// Estratégia de pagamento via Pix.
public class PagamentoPix implements EstrategiaPagamento {

    // Processa o pagamento via Pix com um código aleatório.
    @Override
    public void processarPagamento(double valor) {
        Random rand = new Random();
        String codigoPix = "PIX-" + rand.nextInt(1000000);  // Código aleatório
        System.out.println("Pagando R$" + valor + " via Pix.");
        System.out.println("Código do Pix: " + codigoPix);
    }
}


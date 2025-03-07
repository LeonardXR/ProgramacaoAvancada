package org.example;

// Estratégia de pagamento via boleto.
public class PagamentoBoleto implements EstrategiaPagamento {

    // Gera o boleto com o valor e um código único.
    @Override
    public void processarPagamento(double valor) {
        String codigoBoleto = "BOLETO-" + (int) (Math.random() * 1000000);  // Código aleatório
        System.out.println("Gerando boleto de R$" + valor + ".");
        System.out.println("Código do Boleto: " + codigoBoleto);
    }
}


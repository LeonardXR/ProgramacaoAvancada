package org.example;

// Processa o pagamento com base na estratégia fornecida.
public class ProcessadorPagamento {
    private EstrategiaPagamento estrategiaPagamento;

    // Inicializa o processador com a estratégia de pagamento.
    public ProcessadorPagamento(EstrategiaPagamento estrategiaPagamento) {
        this.estrategiaPagamento = estrategiaPagamento;
    }

    // Processa o pagamento com o valor fornecido.
    public void processar(double valor) {
        estrategiaPagamento.processarPagamento(valor);
    }
}


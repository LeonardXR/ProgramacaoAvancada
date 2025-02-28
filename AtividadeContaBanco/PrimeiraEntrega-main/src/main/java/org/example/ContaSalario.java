package org.example;

class ContaSalario extends ContaCorrente {
    private int saquesGratis = 1;

    public ContaSalario(String numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo, chequeEspecial);
    }

    @Override
    public boolean sacar(double valor) {
        if (saquesGratis > 0) {
            saquesGratis--;
            return super.sacar(valor);
        } else {
            return super.sacar(valor + 5);
        }
    }
}

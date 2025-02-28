package org.example;

class ContaCorrente extends ContaBancaria{
    private double chequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

package org.example;

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

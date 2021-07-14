package semana03.dracmabank;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    protected double saldo = 0;
    private int numeroDaConta;
    private boolean statusDaConta = true;
    private List<String> extrato = new ArrayList<>();

    private Cliente cliente;

    public Conta(double saldo, Cliente cliente) {
        this.saldo = saldo;
        this.numeroDaConta = (int) ((Math.random() * (9999 - 1000)) + 1000);
        this.cliente = cliente;
    }

    public void mostrarInicio() {
        System.out.printf("\nOlá, %s!\nConta nº %d\n", cliente.getNome(), numeroDaConta);
    }

    public void mostrarSaldoAtual() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldo);
    }

    public void mostrarExtrato() {
        System.out.println("\n----Extrato----");
        for (String operacao : extrato) {
            System.out.println(operacao);
        }
        System.out.println("--------");
        mostrarSaldoAtual();
    }

    protected void metodoDoSaque(double valorDoSaque) {
        this.saldo -= valorDoSaque;
        System.out.printf("\nSaque no valor de R$ %.2f realizado com sucesso!\n", valorDoSaque);
        mostrarSaldoAtual();
        extrato.add("Saque: R$ " + valorDoSaque);
    }

    public void sacar(double valorDoSaque) {
        if (saldo >= valorDoSaque) {
            metodoDoSaque(valorDoSaque);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar(double valorDoDeposito) {
        this.saldo += valorDoDeposito;
        System.out.printf("\nDepósito no valor de R$ %.2f realizado com sucesso!\n", valorDoDeposito);
        mostrarSaldoAtual();
        extrato.add("Depósito: R$ " + valorDoDeposito);
    }

    public void encerrarConta() {
        if (statusDaConta) {
            if (saldo != 0) {
                System.out.println("Para encerrar a conta, seu saldo deve ser R$ 0.00");
                mostrarSaldoAtual();
            } else {
                statusDaConta = false;
                System.out.println("Conta encerrada");
                System.exit(1);
            }
        }
    }

}

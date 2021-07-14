package semana03.dracmabank;

public class ContaCorrente extends Conta {

    private double chequeEspecialDisponivel = 0;
    private double chequeEspecialLimite = 0;
    private int senhaGerente = 1010;

    public ContaCorrente(double saldo, Cliente cliente) {
        super(saldo, cliente);
    }

    @Override
    public void mostrarExtrato() {
        super.mostrarExtrato();
        System.out.printf("Limite disponível no Cheque Especial: R$ %.2f\n", chequeEspecialDisponivel);
    }

    @Override
    public void sacar(double valorDoSaque) {
        if (saldo >= valorDoSaque) {
            metodoDoSaque(valorDoSaque);
        } else {
            usarChequeEspecial(valorDoSaque);
        }
    }

    @Override
    public void depositar(double valorDoDeposito) {
        super.depositar(valorDoDeposito);
        if (saldo >= 0) {
            pagarChequeEspecial(valorDoDeposito);
        }
    }

    public void usarChequeEspecial(double valorDoSaque) {
        if (saldo + chequeEspecialDisponivel >= valorDoSaque) {
            chequeEspecialDisponivel -= (valorDoSaque - saldo);
            saldo -= valorDoSaque;
            System.out.printf("Seu saldo atual é R$ %.2f e seu limite de cheque especial R$ %.2f\n", saldo, chequeEspecialDisponivel);
        } else {
            System.out.println("\nSaldo insuficiente");
            mostrarSaldoAtual();
        }
    }

    public void pagarChequeEspecial(double valorDepositado) {
        double saldoAntigo = saldo;
        chequeEspecialDisponivel += valorDepositado;
        double diferencaDoPagamento = chequeEspecialDisponivel - chequeEspecialLimite;
        if (diferencaDoPagamento >= 0) {
            chequeEspecialDisponivel = chequeEspecialLimite;
        }
    }

    public void adicionarLimiteChequeEspecial(double valorChequeEspecial, int senhaDigitada) {
        if (this.senhaGerente == senhaDigitada) {
            this.chequeEspecialLimite = valorChequeEspecial;
            this.chequeEspecialDisponivel = valorChequeEspecial;
            System.out.printf("Limite de R$ %.2f liberado\n", valorChequeEspecial);
        } else {
            System.out.println("Senha incorreta");
        }
    }

}

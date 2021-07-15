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
        if (saldo < 0) {
            pagarChequeEspecial(valorDoDeposito);
        }
        super.depositar(valorDoDeposito);

    }

    public void usarChequeEspecial(double valorDoSaque) {
        if (chequeEspecialDisponivel >= valorDoSaque || saldo + chequeEspecialDisponivel >= valorDoSaque) {
            if (saldo <= 0) {
                chequeEspecialDisponivel -= valorDoSaque;
            } else {
                chequeEspecialDisponivel -= (valorDoSaque - saldo);
            }
            saldo -= valorDoSaque;
            extrato.add("Saque cheque especial: R$ " + fmt.format(valorDoSaque));
            System.out.printf("Seu saldo atual é R$ %.2f e seu limite de cheque especial R$ %.2f\n", saldo, chequeEspecialDisponivel);
        } else {
            System.out.println("Você não possui limite suficiente para realizar este saque");
        }
    }

    public void pagarChequeEspecial(double valorDepositado) {
        chequeEspecialDisponivel += valorDepositado;
        double diferencaDoPagamento = chequeEspecialDisponivel - chequeEspecialLimite;
        // Delimitar que o limite do cheque especial, para ao depositar não aumente
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

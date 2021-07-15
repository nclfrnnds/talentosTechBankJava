package semana03.dracmabank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in).useDelimiter("\n");

        int tipoDeConta = 0;
        boolean realizarOperacao = false;

        System.out.println("Seja bem-vindo ao Dracma Bank!\n");
        do {
            System.out.println("[1] - Conta Corrente [2] - Conta Poupança");
            System.out.print("Escolha o tipo de conta: ");
            validaSystemInteiro(in);
            tipoDeConta = in.nextInt();


            if (tipoDeConta != 1 && tipoDeConta != 2) {
                System.out.println("\nOpção inválida!\n");
            }

        } while (tipoDeConta != 1 && tipoDeConta != 2);

        System.out.print("\nInforme seu nome completo: ");
        String nome = in.next();
        System.out.print("Informe seu cpf: ");
        String cpf = in.next();

        Cliente novoCliente = new Cliente(nome, cpf);
        Conta novaConta = null;

        System.out.printf("Informe o saldo inicial: ");
        validaSystemDouble(in);
        double saldoInicial = validaValorPositivo(in);
        realizarOperacao = true;

        switch (tipoDeConta) {
            case 1:
                novaConta = new ContaCorrente(saldoInicial, novoCliente);
                break;
            case 2:
                novaConta = new ContaPoupanca(saldoInicial, novoCliente);
                break;
        }

        novaConta.mostrarInicio();
        novaConta.mostrarSaldoAtual();

        while (realizarOperacao) {

            System.out.println("\nMENU");
            System.out.println("[1] - Sacar");
            System.out.println("[2] - Depositar");
            System.out.println("[3] - Extrato");
            System.out.println("[4] - Encerrar Conta");
            if (novaConta instanceof ContaCorrente) {
                System.out.println("[5] - Solicitar Cheque Especial");
            }
            System.out.println("[0] - Sair");

            System.out.print("Informe a operação que deseja realizar: ");
            validaSystemInteiro(in);
            int opcaoSelecionada = in.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    System.out.print("\nInforme o valor a sacar: ");
                    validaSystemDouble(in);
                    double saque = validaValorPositivo(in);
                    novaConta.sacar(saque);
                    break;
                case 2:
                    System.out.print("\nInforme o valor a depositar: ");
                    validaSystemDouble(in);
                    double deposito = validaValorPositivo(in);
                    novaConta.depositar(deposito);
                    break;
                case 3:
                    novaConta.mostrarExtrato();
                    break;
                case 4:
                    novaConta.encerrarConta();
                    break;
                case 5:
                    if (novaConta instanceof ContaCorrente) {
                        System.out.print("Informe o limite do cheque especial: ");
                        validaSystemDouble(in);
                        double limiteChequeEspecial = validaValorPositivo(in);
                        System.out.print("\nSenha do Gerente: ");
                        validaSystemInteiro(in);
                        int senhaInformada = in.nextInt();
                        ((ContaCorrente) novaConta).adicionarLimiteChequeEspecial(limiteChequeEspecial, senhaInformada);
                    } else {
                        System.out.println("Essa opção não é válida para este tipo de conta.");
                    }
                    break;
                case 0:
                    System.out.println("\nEncerrando...");
                    realizarOperacao = false;
                    break;
                default:
                    System.out.println("\nOpção inválida.\n");
            }
        }
        in.close();


    }

    public static void validaSystemInteiro(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Você precisa digitar uma número inteiro");
            sc.next();
            System.out.print("Digite novamente: ");
        }
    }

    public static void validaSystemDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.println("Você precisa digitar uma número");
            sc.next();
            System.out.print("Digite novamente: ");
        }
    }

    public static double validaValorPositivo(Scanner sc){

        double numero = sc.nextDouble();
        while(numero < 0){
            System.out.println("Você deve digitar uma valor maior do que zero");
            System.out.print("Digite novamente: ");
            validaSystemDouble(sc);
            numero = sc.nextDouble();
        }

        return numero;
    }
}

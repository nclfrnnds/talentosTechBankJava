package dia2;

import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args) {

        exercicio6();

    }

    public static void validaSystemInInteiro(Scanner input) {
        if (!input.hasNextInt()) {
            System.out.println("Você precisa digitar um número inteiro.");
            input.close();
            System.exit(1);
        }
    }

    public static void validaSystemInDouble(Scanner input) {
        if (!input.hasNextDouble()) {
            System.out.println("Você precisa digitar um número real.");
            input.close();
            System.exit(1);
        }
    }

    public static void validaSystemInString(Scanner input) {
        if (!input.hasNext()) {
            System.out.println("Você precisa digitar uma string.");
            input.close();
            System.exit(1);
        }
    }

    public static void exercicio1() {
        /*
        Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe um número inteiro: ");
        validaSystemInInteiro(input);
        int numero = input.nextInt();

        String resposta = numero % 2 == 0 ? "par" : "ímpar";
        System.out.printf("O número %d é %s", numero, resposta);

        input.close();
    }

    public static void exercicio2() {
        /*
        Elabore um algoritmo que dada a idade de um nadador classifique-o em uma das seguintes categorias:
        Infantil A = 5 a 7 anos
        Infantil B = 8 a 11 anos
        Juvenil A = 12 a 13 anos
        Juvenil B = 14 a 17 anos
        Adultos = Maiores de 18 anos
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe a idade: ");
        validaSystemInInteiro(input);
        int idade = input.nextInt();
        String resposta = "";

        if (idade >= 5 && idade <= 7) resposta = "Categoria Infantil A";
        else if (idade >= 8 && idade <= 11) resposta = "Categoria Infantil B";
        else if (idade >= 12 && idade <= 13) resposta = "Categoria Juvenil A";
        else if (idade >= 14 && idade <= 17) resposta = "Categoria Juvenil B";
        else if (idade >= 18) resposta = "Categoria Adultos";
        else resposta = "Idade não permitida!";

        System.out.println(resposta);
        input.close();
    }

    public static void exercicio3() {
        /*
        Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor.
        Escreva um algoritmo que determina o maior também.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o primeiro número: ");
        validaSystemInInteiro(input);
        int num1 = input.nextInt();
        System.out.print("Informe o segundo número: ");
        validaSystemInInteiro(input);
        int num2 = input.nextInt();

        String resposta = "O número %d é o menor";

        /*
        if (num1 < num2) System.out.printf(resposta, num1);
        else if (num2 < num1) System.out.printf(resposta, num2);
        else System.out.println("Os números são iguais!");
        */

        if (num1 == num2) System.out.printf("Os números são iguais!");
        else System.out.printf(num1 < num2 ? String.format(resposta, num1) : String.format(resposta, num2));

        input.close();
    }

    public static void exercicio4() {
        /*
        Construa um algoritmo que leia 10 valores inteiros e positivos e:
        Encontre o maior valor
        Encontre o menor valor
        Calcule a média dos números lidos
        */

        Scanner input = new Scanner(System.in);
        final int QTD = 10;
        double numeros[] = new double[QTD];

        for(int cont = 0; cont < QTD; cont++) {
            System.out.printf("(%d) Informe o número: ", cont + 1);
            validaSystemInDouble(input);
            numeros[cont] = input.nextDouble();
        }

        double maior = numeros[0];
        double menor = numeros[0];
        double media = 0;

        for (int cont = 0; cont < QTD; cont++) {
            if (numeros[cont] >= maior) maior = numeros[cont];
            if (numeros[cont] <= menor) menor = numeros[cont];
            media += numeros[cont];
        }

        media = media / QTD;
        System.out.printf("Maior: %.2f\nMenor: %.2f\nMédia: %.2f", maior, menor, media);

        input.close();
    }

    public static void exercicio5() {
        /*
        Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações matemáticas
        (adição, subtração, multiplicação e divisão). Todas as operações serão entre dois valores.
        No começo do algoritmo pergunte ao usuário qual operação ele deseja fazer e quais são os valores.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe a operação:\na - adição\ns - subtração\nm - multiplicação\nd - divisão\n");
        validaSystemInString(input);
        char operacao = input.next().toUpperCase().charAt(0);

        System.out.print("Informe o primeiro número: ");
        validaSystemInDouble(input);
        double numero1 = input.nextDouble();

        System.out.print("Informe o segundo número: ");
        validaSystemInDouble(input);
        double numero2 = input.nextDouble();

        double resultado;
        switch (operacao) {
            case 'A': {
                resultado = numero1 + numero2;
                System.out.printf("Adição: %.2f + %.2f = %.2f", numero1, numero2, resultado);
                break;
            }
            case 'S': {
                resultado = numero1 - numero2;
                System.out.printf("Subtração: %.2f - %.2f = %.2f", numero1, numero2, resultado);
                break;
            }
            case 'M': {
                resultado = numero1 * numero2;
                System.out.printf("Multiplicação: %.2f * %.2f = %.2f", numero1, numero2, resultado);
                break;
            }
            case 'D': {
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.printf("Divisão: %.2f / %.2f = %.2f", numero1, numero2, resultado);
                    break;
                }
                else {
                    System.out.printf("Impossível dividir por zero!");
                    break;
                }
            }
            default : {
                System.out.println("Operação inválida!");
            }
        }

        input.close();
    }

    public static void exercicio6() {
        /*
        Faça a implementação do Jogo Pedra, Papel e Tesoura (Jokempô).
        O algoritmo deverá perguntar qual é a escolha do jogador 1 (Pedra [pe], Papel [pa], Tesoura [t])
        e deverá fazer o mesmo para o jogador 2.
        No final da execução o algoritmo deverá dizer qual é o jogador vencedor ou se houve empate.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Jogador A - Digite 1 para PEDRA, 2 para PAPEL ou 3 para TESOURA: ");
        int a = input.nextInt();

        System.out.print("Jogador B - Digite 1 para PEDRA, 2 para PAPEL ou 3 para TESOURA: ");
        int b = input.nextInt();

        if (a == b)
            System.out.println("Empate");
        else if (a == 1 && b == 2 || a == 2 && b == 3 || a == 3 && b == 1)
            System.out.println("Jogador B venceu!");
        else
            System.out.println("Jogador A venceu!");

        input.close();
    }

}

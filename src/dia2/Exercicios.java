package dia2;

import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args) {

        exercicio2();

    }

    public static void exercicio1() {
        /*
        Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe um número inteiro: ");
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
        int idade = input.nextInt();
        String resposta = "";

        if (idade >= 5 && idade <= 7) {
            resposta = "Infantil A";
        } else if (idade >= 8 && idade <= 11) {
            resposta = "Infantil B";
        } else if (idade >= 12 && idade <= 13) {
            resposta = "Juvenil A";
        } else if (idade >= 14 && idade <= 17) {
            resposta = "Juvenil B";
        } else if (idade >= 18) {
            resposta = "Adultos";
        } else {
            resposta = "Idade não permitida!";
        }

        System.out.println(resposta);
        input.close();
    }

    public static void exercicio3() {
        /*
        Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor.
        Escreva um algoritmo que determina o maior também.
        */

        Scanner input = new Scanner(System.in);



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



        input.close();
    }

    public static void exercicio5() {
        /*
        Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações matemáticas
        (adição, subtração, multiplicação e divisão). Todas as operações serão entre dois valores.
        No começo do algoritmo pergunte ao usuário qual operação ele deseja fazer e quais são os valores.
        */

        Scanner input = new Scanner(System.in);



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



        input.close();
    }

}

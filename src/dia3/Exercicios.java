package dia3;

import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args) {
        exercicio2();
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

    public static void exercicio2() {
        /*
        Construa um algoritmo usando uma estrutura de repetição que calcule o fatorial de um número.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe um número: ");
        validaSystemInInteiro(input);
        int numero = input.nextInt();

        int resultado = 1;
        while (numero > 1) {
            resultado *= numero;
            numero--;
        }

        System.out.println(resultado);

        input.close();
    }

}

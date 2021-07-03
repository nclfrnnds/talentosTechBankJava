package semana01;

import java.util.Scanner;

public class Dia05 {

    public static void main(String[] args) {
        //exercicio1();
        exercicio2i();
        exercicio2ii();
        exercicio2iii();
        exercicio2iv();
        exercicio2v();
        exercicio2vi();
    }

    public static void exercicio1() {
        /*
        Dois números são inseridos pelo teclado.
        Escreva um programa para encontrar o valor de um número elevado à potência de outro.
        (Não use o método Math.pow integrado Java)
        Por exemplo, 2 elevado 3 = 8
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe a base: ");
        int base = input.nextInt();

        System.out.print("Informe a potência: ");
        int potencia = input.nextInt();

        int resultado = 1;
        for (int i = 0; i < potencia; i++) {
            resultado *= base;
        }

        System.out.printf("%d elevado por %d é igual a %d", base, potencia, resultado);
        input.close();
    }

    public static void exercicio2i() {
        for (int i = 1; i <= 5; i++) {
            System.out.print("* * * * * * * * *\n");
        }
    }

    public static void exercicio2ii() {
        int linhas = 5;
        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void exercicio2iii() {
        int linhas = 5;
        for (int i = 1; i <= linhas; i++) {
            for (int j = linhas - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

    public static void exercicio2iv() {
        int linhas = 5;
        for (int i = 1; i <= linhas; i++) {
            for (int j = linhas - i; j > 0; j--) {
                System.out.print("  ");
            }
            int k = 0;
            while (k != 2 * i - 1) {
                System.out.print("* ");
                k++;
            }
            System.out.print("\n");
        }
    }

    public static void exercicio2v() {
        int linhas = 5;
        for (int i = 1; i <= linhas; i++) {
            for (int j = linhas - i; j > 0; j--) {
                System.out.print("  ");
            }
            int k = 0;
            while (k != 2 * i - 1) {
                System.out.print(i + " ");
                k++;
            }
            System.out.print("\n");
        }
    }

    public static void exercicio2vi() {
        int linhas = 5;
        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= 2 * (linhas - i); j++) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.print(" " + k);
            }
            for (int k = 2; k <= i; k++) {
                System.out.print(" " + k);
            }
            System.out.print("\n");
        }
    }

}

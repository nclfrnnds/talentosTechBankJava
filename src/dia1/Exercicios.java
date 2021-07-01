package dia1;

import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args) {



    }

    public static void exercicio1() {
        /*
        Escreva um algoritmo que armazene o valor 99 em uma variável Y e o valor 11 em uma variável Z.
        A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos fazendo com que
        o valor que está em Y passe para Z e vice-versa.
        Ao final, escrever os valores que ficaram armazenados nas variáveis.
        */

        short x = 0, y = 99, z = 11;

        System.out.println("y: " + y + "\nz: " + z);

        x = y;
        y = z;
        z = x;

        System.out.println("\ny: " + y + "\nz: " + z);
    }

    public static void exercicio2() {
        /*
        Escreva um algoritmo para ler um valor (do teclado) e escrever (na tela) o seu antecessor.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe um valor: ");
        int valor = input.nextInt();
        System.out.println("O antecessor de " + valor + " é " + --valor);

        input.close();
    }

    public static void exercicio3() {
        /*
        Escreva um algoritmo para ler as dimensões de um retângulo (base e altura),
        calcular e escrever a área do retângulo.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe a base do retângulo: ");
        double base = input.nextDouble();
        System.out.print("Informe a altura do retângulo: ");
        double altura = input.nextDouble();
        System.out.println("A área do retângulo é " + (base*altura));

        input.close();
    }

    public static void exercicio4() {
        /*
        Escreva um algoritmo para ler o número total de eleitores de um município,
        o número de votos brancos, nulos e válidos.
        Calcular e escrever o percentual que cada um representa em relação ao total de eleitores.
        */

        Scanner input = new Scanner(System.in);

        System.out.print("Informe o número total de eleitores do município: ");
        int eleitores = input.nextInt();
        System.out.print("Informe o número total de votos válidos: ");
        int validos = input.nextInt();
        System.out.print("Informe o número total de votos brancos: ");
        int brancos = input.nextInt();
        System.out.print("Informe o número total de votos nulos: ");
        int nulos = input.nextInt();

        System.out.printf("O percentual de votos válidos é de %.2f%%\n" +
                "O percentual de votos brancos é de %.2f%%\n" +
                "O percentual de votos nulos é de %.2f%%",
                ((double) validos * 100 / eleitores),
                ((double) brancos * 100 / eleitores),
                ((double) nulos * 100 / eleitores));

        input.close();
    }

}

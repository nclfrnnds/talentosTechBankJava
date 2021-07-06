package semana02;

import java.util.*;

public class Dia07 {

    public static void main(String[] args) {
        exercicio4();
    }

    public static void exercicio1() {
        /*
        Escreva um algoritmo que leia números insira em um array e após mostre os números informados na tela.
        Ler somente 5 números.
        */

        Scanner input = new Scanner(System.in);

        int numeros[] = new int[5];
        List<Integer> arrayNumeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Informe um número: ");
            numeros[i] = input.nextInt();
            int numero = numeros[i];
            arrayNumeros.add(numero);
        }

        System.out.println(Arrays.toString(numeros));
        System.out.println(arrayNumeros);

        input.close();
    }

    public static void exercicio2() {
        /*
        Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números negativos.
        */

        Scanner input = new Scanner(System.in);

        int numeros[] = new int[5];
        List<Integer> arrayNumeros = new ArrayList<>();
        int negativos = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Informe um número: ");
            numeros[i] = input.nextInt();
            int numero = numeros[i];
            if (numero < 0) {
                arrayNumeros.add(numero);
                negativos++;
            }
        }

        System.out.println(Arrays.toString(numeros));
        System.out.println(arrayNumeros);
        System.out.println("Total de números negativos: " + negativos);

        //System.out.println(arrayNumeros.stream().filter(numero -> numero < 0).count());

        input.close();
    }

    public static void exercicio3() {
        /*
        Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números pares.
        */

        Scanner input = new Scanner(System.in);

        int numeros[] = new int[5];
        List<Integer> arrayNumeros = new ArrayList<>();
        int pares = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Informe um número: ");
            numeros[i] = input.nextInt();
            int numero = numeros[i];
            if (numero % 2 == 0 && numero != 0) {
                arrayNumeros.add(numero);
                pares++;
            }
        }

        System.out.println(Arrays.toString(numeros));
        System.out.println(arrayNumeros);
        System.out.println("Total de números pares: " + pares);

        //System.out.println(arrayNumeros.stream().filter(numero -> numero % 2 == 0).count());

        input.close();
    }

    public static void exercicio4() {
        /*
        Escreva um algoritmo que leia números, insira em um array e após mostre o maior valor.
        */

        Scanner input = new Scanner(System.in);

        List<Integer> arrayNumeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Informe um número: ");
            arrayNumeros.add(input.nextInt());
        }

        int maior = arrayNumeros.get(0);
        for (Integer numero : arrayNumeros) {
            if (numero > maior) {
                maior = numero;
            }
        }
        System.out.println("O maior número digitado é " + maior);

        //System.out.println(Collections.max(arrayNumeros));
        //System.out.println(arrayNumeros.stream().max(Integer::compare).get());
        //System.out.println(arrayNumeros.stream().mapToInt(v -> v).max().getAsInt());

        input.close();
    }

    public static void exercicio5() {
        /*
        Escreva um algoritmo que simula um jogo da forca simples.
        o usuario precisara adivinhar uma palavra chutando cada letra em no máximo 10 chutes,
        caso o usuario acerte a letra o jogo dirá que ele acertou, caso tenha errado,
        o numero de tentativas vai diminuindo.
        Caso o numero de tentativas chegue a 0 o usuário perde.
        */

        Scanner input = new Scanner(System.in);



        input.close();
    }

}

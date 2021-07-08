package semana02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dia08 {

    public static void main(String[] args) {
        exercicio5();
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

        System.out.print("Jogador 1, escolha a palavra que deverá ser adivinhada: ");
        String palavraDigitada = input.next();

        System.out.print("Jogador 1, dê uma dica sobre a palavra: ");
        String dicaPalavra = input.next();

        int chutes = 10;
        palavraDigitada = palavraDigitada.trim();
        char[] palavra = palavraDigitada.toCharArray();

        List<Boolean> acertos = new ArrayList<>(Collections.nCopies(
                palavra.length, false)
        );

        System.out.printf("Jogador 2, sua dica é %s\n", dicaPalavra);

        while (chutes > 0 && acertos.contains(false)) {
            System.out.print("Jogador 2, chute uma letra: ");
            char chute = input.next().charAt(0);

            boolean errou = true;
            for (int i = 0; i < palavra.length; i++) {
                if (chute == palavra[i]) {
                    acertos.set(i, true);
                    errou = false;
                }
            }

            if (errou) {
                chutes--;
                System.out.printf("Jogador 2 errou! Agora você só tem %s chutes\n", chutes);
            }

            for (int i = 0; i < palavra.length; i++) {
                if (acertos.get(i)) {
                    System.out.printf("%s ", palavra[i]);
                } else {
                    System.out.print("_ ");
                }
            }

            System.out.println();

        }

        if (!acertos.contains(false)) {
            System.out.println("Jogador 2 ganhou!");
        } else {
            System.out.println("Jogador 1 ganhou!");
        }

        input.close();
    }

}

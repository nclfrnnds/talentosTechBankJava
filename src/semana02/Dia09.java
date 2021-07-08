package semana02;

import java.util.Random;

public class Dia09 {

    public static void main(String[] args) {
        desafio();
    }

    public static void desafio() {
        /*
        Dado um array de números inteiros com valores negativos e positivos, encontro o número mais próximo de zero.
        Se houver valores como 2 e -2, considere o número positivo.
        */

        /* intervalo dos números que serão gerados aleatoriamente */
        Random random = new Random();
        int min = -20, max = 20;

        /* vetor que será preenchido com os valores aleatórios */
        final int TAM = 10;
        int vetor[] = new int[TAM];

        /* laço pra preencher o vetor com os valores aleatórios */
        for (int i = 0; i < vetor.length; i ++) {
            vetor[i] = min + (int) (Math.random() * ((max - (min)) + 1));
        }

        /* impressão do vetor com os valores aleatórios */
        for (int num : vetor) {
            System.out.printf("%d ", num);
        }

        /* laço para verificar o número do vetor que está mais próximo de zero */
        int indiceMenor = 0;
        for (int i = 0; i < vetor.length; i++) {
            boolean proximoZero = Math.abs(vetor[i]) < Math.abs(vetor[indiceMenor]);
            boolean proximoZeroPositivo = Math.abs(vetor[i])
                    == Math.abs(vetor[indiceMenor]) && vetor[i] > vetor[indiceMenor];
            if (proximoZero || proximoZeroPositivo) {
                indiceMenor = i;
            }
        }

        System.out.printf("\nO valor mais próximo de zero é %d", vetor[indiceMenor]);
    }

}

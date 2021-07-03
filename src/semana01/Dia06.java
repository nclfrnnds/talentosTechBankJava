package semana01;

import java.util.Random;

public class Dia06 {

    public static void main(String[] args) {

        Random random = new Random();
        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        System.out.println("Array aleatório: ");
        for (int i:arr) {
            System.out.print(i+" ");
        }

        selectionSort(arr);
        bubbleSort(arr);

    }

    public static void imprimirInvertido() {
        /*
        Dado um array com 20 números, imprima seus valores de trás para frente.
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
        */

        int arr[] = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        for (int i = arr.length; i > 0; i--) {
            System.out.print(arr[i-1]+" ");
        }
    }

    public static void selectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int menor = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[menor]){
                    menor = j;
                }
            }
            int troca = arr[menor];
            arr[menor] = arr[i];
            arr[i] = troca;
        }
        System.out.println("\nOrdenado com selection sort: ");
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < (arr.length-i); j++){
                if (arr[j-1] > arr[j]){
                    int troca = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = troca;
                }
            }
        }
        System.out.println("\nOrdenado com bubble sort: ");
        for (int i:arr) {
            System.out.print(i+" ");
        }
    }

}

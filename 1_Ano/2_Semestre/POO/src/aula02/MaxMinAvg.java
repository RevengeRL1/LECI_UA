package aula02;

import java.util.Scanner;

public class MaxMinAvg {
    public static void main(String[] args) {
        double min, max, avg, aux, first;
        int counter = 1;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a real number: ");
        first = input.nextDouble();
        min = first;
        max = first;
        avg = first;

        do{
            counter++;
            System.out.print("Input a new number: ");
            aux = input.nextDouble();
            if (aux < min){
                min = aux;
            }
            else if (aux > max){
                max = aux;
            }
            avg += aux;
        }while(aux != first);

        avg /= counter;

        System.out.print(String.format("\nMax: %.2f\nMin: %.2f\nAverage: %.2f\n%d numbers\n", max, min, avg, counter));

        input.close();
    }
}

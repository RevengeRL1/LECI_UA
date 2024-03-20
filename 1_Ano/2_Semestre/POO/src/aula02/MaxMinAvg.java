package aula02;

import java.util.Scanner;

public class MaxMinAvg {
    public static void main(String[] args) {
        double min, max, avg, aux, first;
        int counter = 1;
        Scanner input = new Scanner(System.in);

        System.out.println("Input a real number: ");
        first = input.nextDouble();
        min = first;
        max = first;
        avg = first;

        do{
            counter++;
            System.out.println("Input a new number: ");
            aux = input.nextDouble();
            if (aux < min){
                min = aux;
            }
            else if (aux > max){
                max = aux;
            }
            avg += aux;
        }while(aux != first);

        
    }
}

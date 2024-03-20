package aula02;

import java.util.Scanner;

public class DecreasingCounter {
    public static void main(String[] args) {
        int value;
        Scanner input = new Scanner(System.in);

        do{
            System.out.print("Input positive int value: ");
            value = input.nextInt();
        }while(value <= 0);

        for(int i = value; i >= 0; i--){
            if(i % 10 == 0){ System.out.print(String.format("%d,\n", i));}
            else{ System.out.print(String.format("%d,", i));}
        }

        input.close();
    }
}

package aula03;

import java.util.Scanner;

public class DecreasingSum {
    public static void main(String[] args) {
        int number;
        int sum = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a positive number: ");
        number = input.nextInt();

        for(int i = 1; i <= number; i++){
            if (isPrime(i) == true){
                sum += i;
            }
        }

        System.out.printf("\nSum of all positive prime numbers up to %d: %d\n", number, sum);

        input.close();
    }

    public static boolean isPositive(int number){
        if (number > 0){ return true; }
        return false;
    }

    public static boolean isPrime(int number){
        if(number <= 0) { return false; }
        if(number == 1 || number == 2) { return true; }
        
        for(int i = 2; i < number; i++){
            if(number % i == 0) { return false; }
        }

        return true;
    }
}

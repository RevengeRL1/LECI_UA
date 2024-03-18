package aula02;

import java.util.Scanner;

public class KmToMiles {
    public static void main(String[] args) {
        double distance;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Distance value (in Kms): ");
        distance = input.nextDouble();

        System.out.println(String.format("\nDistance value (in miles): %.2f", distance / 1.609));

        input.close();
    }
}

package aula02;

import java.util.Scanner;

public class TriangleCalculator {
    public static void main(String[] args) {
        double side1, side2;
        double hypotenuse;
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("\nLength of side1: ");
            side1 = input.nextDouble();
            if (side1 <= 0){
                System.out.println("\nInvalid value.");
                continue;
            }
            System.out.print("Length of side2: ");
            side2 = input.nextDouble();
            if (side2 <= 0){
                System.out.println("\nInvalid value.");
                continue;
            }
            break;
        }   

        hypotenuse = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));

        System.out.println(String.format("\nHypotenuse length: %.2f", hypotenuse));
        System.out.println(String.format("Angle between side1 and hypotenuse: %.2f", Math.toDegrees(Math.acos(side1/hypotenuse))));
        input.close();
    }
}

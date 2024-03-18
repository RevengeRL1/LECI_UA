package aula02;

import java.util.Scanner;

public class AverageVelocity {
    public static void main(String[] args) {
        double velocity1, velocity2, distance1, distance2;
        Scanner input = new Scanner(System.in);

        System.out.print("First velocity value: ");
        velocity1 = input.nextDouble();
        System.out.print("First distance traveled value: ");
        distance1 = input.nextDouble();
        System.out.print("Second velocity value: ");
        velocity2 = input.nextDouble();
        System.out.print("Second distance traveled value: ");
        distance2 = input.nextDouble();

        System.out.println(String.format("\nAverage velocity of the full trip: %.2f", (distance1 + distance2 / (distance1 / velocity1) + (distance2 / velocity2))));

        input.close();
    }
}

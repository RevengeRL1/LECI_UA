package aula02;

import java.util.Scanner;

public class PointDistance {
    public static void main(String[] args) {
        int x1, x2, y1, y2;
        Scanner input = new Scanner(System.in);

        System.out.print("Input x of point 1: ");
        x1 = input.nextInt();

        System.out.print("Input x of point 1: ");
        y1 = input.nextInt();

        System.out.print("\nInput y of point 2: ");
        x2 = input.nextInt();

        System.out.print("Input y of point 2: ");
        y2 = input.nextInt();

        System.out.println(String.format("\nDistance between both points: %.2f", Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)))));

        input.close();
    }
}

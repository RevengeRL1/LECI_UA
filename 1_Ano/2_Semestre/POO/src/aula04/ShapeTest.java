package aula04;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius, side1, side2, side3;

        // Circle tests
        Circle c1 = new Circle(10);
        System.err.println("\n|Circle c1|");
        System.out.println(c1);

        System.out.print("\nEnter the radius for a new circle (c2): ");
        radius = input.nextDouble();
        Circle c2 = new Circle(radius);
        System.out.println("\n|Circle c2|");
        System.out.println(c2);

        if(c1.equals(c2)) { System.out.println("\nCircle c1 and c2 are equal."); } else { System.out.println("\nCircle c1 and c2 are different.");}



        //Triangle tests
        Triangle t1 = new Triangle(3, 4, 5);
        
        input.close();
    }
}

package aula04;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius, side1, side2, side3, length, width;
        Triangle t2 = new Triangle(0, 0, 0);

        // Circle tests
        Circle c1 = new Circle(10);
        System.out.println("\n|Circle c1|");
        System.out.println(c1);

        System.out.print("\nEnter the radius for a new circle (c2): ");
        radius = input.nextDouble();
        Circle c2 = new Circle(radius);
        System.out.println("\n|Circle c2|");
        System.out.println(c2);

        if(c1.equals(c2)) { System.out.println("\nCircle c1 and c2 are equal."); } else { System.out.println("\nCircle c1 and c2 are different.");}



        // Triangle tests
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println("\n|Triangle t1|");
        System.out.println(t1);

        System.out.print("\nEnter side1 for a new triangle (t2): ");
        side1 = input.nextDouble();
        System.out.print("\nEnter side2 for a new triangle (t2): ");
        side2 = input.nextDouble();
        System.out.print("\nEnter side3 for a new triangle (t2): ");
        side3 = input.nextDouble();

        t2.setSide1(side1);
        t2.setSide2(side2);
        t2.setSide3(side3);
        System.out.println("\n|Triangle t2|");
        System.out.println(t2);


        // Rectangle tests
        Rectangle r1 = new Rectangle(20, 30);
        System.out.println("\n|Rectangle r1|");
        System.out.println(r1);

        System.out.print("\nEnter the length for a new rectangle (r2): ");
        length = input.nextDouble();
        System.out.print("Enter the width for a new rectangle (r2): ");
        width = input.nextDouble();
        Rectangle r2 = new Rectangle(length, width);
        System.out.println("\n|Rectangle r2|");
        System.out.println(r2);

        if(r1.equals(r2)) { System.out.println("\nRectangle r1 and r2 are equal."); } else { System.out.println("\nRectangle r1 and r2 are different.");}
        input.close();
    }
}

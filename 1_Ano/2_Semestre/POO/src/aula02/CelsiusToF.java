package aula02;

import java.util.Scanner;

public class CelsiusToF {
    public static void main(String[] args) {
        double value;
        Scanner input = new Scanner(System.in);

        System.out.print("Temperature value (in Celsius): ");
        value = input.nextDouble();

        System.out.println(String.format("\nTemperature value (in F): ", (1.8 * value) + 32));
        
        input.close();
    }
}

package aula02;

import java.util.Scanner;

public class Energy {
    public static void main(String[] args) {
        double initialTemperature;
        double finalTemperature;
        double waterQuantity;
        Scanner input = new Scanner(System.in);

        System.out.print("Initial temperature value (in Celsius): ");
        initialTemperature = input.nextDouble();

        System.out.print("\nFinal temperature value (in Celsius): ");
        finalTemperature = input.nextDouble();

        System.out.print("\nWater quantity (in Kilograms): ");
        waterQuantity = input.nextDouble();

        System.out.print(String.format("\nEnergy needed to heat %.2f Kgs of water from %.2fºC to %.2fºC: %.2f J ", waterQuantity, initialTemperature, finalTemperature, waterQuantity * (finalTemperature - initialTemperature) * 4184));

        input.close();
    }
}

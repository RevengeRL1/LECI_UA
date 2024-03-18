package aula02;

import java.util.Scanner;

public class InvestmentCalculator {
    public static void main(String[] args) {
        double initialInvestment;
        double interestRate;
        double finalValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Initial investment amount: ");
        initialInvestment = input.nextDouble();
        finalValue = initialInvestment;

        System.out.print("Interest rate: ");
        interestRate= input.nextDouble();

        for (int i = 0; i < 3; i++){
            finalValue = (finalValue * (interestRate / 100)) + finalValue;
        }

        System.out.println(String.format("\nFinal value after 3 months: %.3f", finalValue));

        input.close();
    }
}

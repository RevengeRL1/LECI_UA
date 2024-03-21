package aula03;

import java.util.Scanner;

public class InvestmentCalculator2 {
    public static void main(String[] args) {
        double investment, interest;
        Scanner input = new Scanner(System.in);
        
        do{
            System.out.print("Amount invested (has to be a multiple of 1000): ");
            investment = input.nextDouble();
        }while(!isPositive(investment) || investment % 1000 != 0);
        
        do{
            System.out.print("\nInterest rate (0% to 5%): ");
            interest = input.nextDouble();
        }while(!interestIsValid(interest));

        interest = interest / 100;

        for(int i = 0; i < 12; i++){
            investment += investment*interest;
        }

        System.err.printf("\nAmount in account after 12 months: %.3f\n", investment);

        input.close();
    }

    public static boolean interestIsValid(double interest){
        if (interest > 5 || interest < 0){
            return false;
        }
        return true;
    }

    public static boolean isPositive(double number){
        if (number < 0){
            return false;
        }
        return true;
    }
}

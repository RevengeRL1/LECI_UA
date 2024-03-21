package aula03;

import java.util.Scanner;


public class HighLow {
    public static void main(String[] args) {
        int random, guess;
        String answer = "Y";
        Scanner input = new Scanner(System.in);

        random = (int) (Math.random() * 101);

        while(answer.toUpperCase().equals("Y") || answer.toUpperCase().equals("YES")){
            guess = -1;
            random = (int) (Math.random() * 101);
            while(guess != random){
                System.out.print("Guess the random number between 0 and 100: ");
                guess = input.nextInt();
                if (guess < 0 || guess > 100){
                    continue;
                }
                else if (guess == random){
                    System.out.println("You guessed the number.");
                }
                
                else if (guess < random){
                    System.out.println("Too low.");
                }

                else {
                    System.out.println("Too high.");
                }
            }
            System.out.println("Want to play again? Type (Y)es" );
            answer = input.next();
        }
        input.close();
    }
}

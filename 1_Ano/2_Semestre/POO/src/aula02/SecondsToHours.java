package aula02;

import java.util.Scanner;

public class SecondsToHours {
    public static void main(String[] args) {
        int seconds, minutes, hours;
        Scanner input = new Scanner(System.in);

        System.out.print("Input amount of seconds: ");
        seconds = input.nextInt();

        hours = seconds / 3600;
        minutes = seconds / 60 % 60;
        seconds = seconds % 60;

        System.out.println(String.format("Time in hh:mm:ss format: %02d:%02d:%02d", hours, minutes, seconds));

        input.close();
    }    
}

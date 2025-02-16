import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2;

        String input = scanner.nextLine();
        scanner2 = new Scanner(input);

        while (scanner2.hasNext()){
            String input2 = scanner2.next();
            System.out.println(input2);
        }


        
    }
}

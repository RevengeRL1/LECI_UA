import java.util.Scanner;

public class b1_1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.printf("Operation (number op number): ");
        double var1 = a.nextDouble();
        String op = a.next();
        double var2 = a.nextDouble();
        double result = 0.0;

        switch (op){
            case "+":
                result = var1 + var2;
                break;
            case "-":
                result = var1 - var2;
                break;
            case "*":
                result = var1 * var2;
                break;
            case "/":
                if (var2 == 0.0){
                    System.err.println("Cannot divide by zero");
                    System.exit(1);
                }
                result = var1 / var2;
                break;
            default:
                System.err.println("Not a valid operator");
                System.exit(1);
        }

        System.out.printf("%.1f %s %.1f = %.1f\n", var1, op, var2, result);
        a.close();
   }
}
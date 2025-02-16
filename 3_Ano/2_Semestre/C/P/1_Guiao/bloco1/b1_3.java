import java.util.Scanner;
import java.util.Stack;

public class b1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        
        while (true) {
            System.out.print("Enter the expression in RPN format (exit to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Scanner scanner2 = new Scanner(input);
            boolean error = false;

            while (scanner2.hasNext()) {
                if (scanner2.hasNextDouble()) {
                    stack.push(scanner2.nextDouble());
                } else {
                    String op = scanner2.next();

                    if (stack.size() < 2) {
                        System.err.println("Error: Invalid syntax (not enough operands)");
                        error = true;
                        break;
                    }

                    double var2 = stack.pop();
                    double var1 = stack.pop();
                    double result = 0;

                    switch (op) {
                        case "+" -> result = var1 + var2;
                        case "-" -> result = var1 - var2;
                        case "*" -> result = var1 * var2;
                        case "/" -> {
                            if (var2 == 0.0) {
                                System.err.println("Error: Cannot divide by zero");
                                error = true;
                                break;
                            }
                            result = var1 / var2;
                        }
                        default -> {
                            System.err.println("Error: Invalid operator '" + op + "'");
                            error = true;
                        }
                    }

                    if (error) break;
                    stack.push(result);
                }
            }

            scanner2.close();

            if (!error && stack.size() == 1) {
                System.out.println("Result: " + stack.pop());
            } else if (!error) {
                System.err.println("Error: Invalid expression (extra operands left in stack)");
            }

            stack.clear();
        }

        scanner.close();
    }
}

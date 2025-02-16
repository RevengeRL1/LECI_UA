import java.util.Scanner;
import java.util.HashMap;

public class b1_2 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        HashMap <String, Double> variables = new HashMap<>();
        System.out.printf("Operation (number op number): ");
        Double result = 0.0;

        while(true){
            if (!a.hasNext()) break;
            
            // Eliminate whitespaces
            String input = a.nextLine().trim();

            // Check if expression matches (variable = number) format
            if (input.matches("[a-zA-Z]+\\s*=\\s*\\d+(\\.\\d+)?")) {
                String[] parts = input.split("=");
                String varName = parts[0].trim();
                double value = Double.parseDouble(parts[1].trim());

                // Assign value to variable
                variables.put(varName, value);
                System.out.printf("%s = %.2f\n", varName, value);
                continue;
            }

            // Check if expression matches (variable = variable +-/* number) format
            if (input.matches("[a-zA-Z]+\\s*=\\s*[a-zA-Z]+\\s*[+-/*]\\s*\\d+")){
                String[] parts = input.split("=");
                String var1Name = parts[0].trim();
                String expression = parts[1].trim();
                
                String[] exprParts = expression.split("\\s+");
                if (exprParts.length != 3) {
                    System.err.println("Invalid expression format.");
                    continue;
                }

                String var2Name = exprParts[0];
                String op = exprParts[1];
                double value;
                
                // Check if second variable exists
                if (variables.containsKey(var2Name)) {
                    value = variables.get(var2Name);
                } else {
                    System.err.printf("Variable %s does not exist\n", var2Name);
                    continue;
                }

                double num;

                try {
                    num = Double.parseDouble(exprParts[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format.");
                    continue;
                }
                
                // Perform right-side expression operation
                switch (op) {
                    case "+":
                        result = value + num;
                        break;
                    case "-":
                        result = value - num;
                        break;
                    case "*":
                        result = value * num;
                        break;
                    case "/":
                        if (num == 0.0) {
                            System.err.println("Cannot divide by zero");
                            continue;
                        }
                        result = value / num;
                        break;
                    default:
                        System.err.println("Not a valid operator");
                        continue;
                }

                // Assign value to variable
                variables.put(var1Name, result);
                System.out.printf("%s = %.2f\n", var1Name, result);
                continue;
            }
            

            // If it's not a variable assignment, check if it's a valid regular operation
            String[] parts = input.split("\\s+");
            if (parts.length == 3){
                double var1, var2;
                String op = parts[1];
                
                // Check if any of the operands are stored variables
                if (variables.containsKey(parts[0])){
                    var1 = variables.get(parts[0]);
                } else {
                    try {
                        var1 = Double.parseDouble(parts[0]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid variable or number" + parts[0]);
                        continue;
                    }
                }

                if (variables.containsKey(parts[2])) {
                    var2 = variables.get(parts[2]);
                } else {
                    try {
                        var2 = Double.parseDouble(parts[2]);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid variable or number: " + parts[2]);
                        continue;
                    }
                }

                // Perform the operation
                switch (op) {
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
                        if (var2 == 0.0) {
                            System.err.println("Cannot divide by zero");
                            continue;
                        }
                        result = var1 / var2;
                        break;
                    default:
                        System.err.println("Not a valid operator");
                        continue;
                }
                
                System.out.printf("%.2f %s %.2f = %.2f\n", var1, op, var2, result);
                
                } else {
                    System.err.println("Invalid expression format.");
                }
            }
            a.close();
        }
}
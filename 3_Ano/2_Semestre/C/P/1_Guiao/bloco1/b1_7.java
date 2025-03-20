import java.util.Scanner;

public class b1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(scanner.nextLine());

        ExpressionTree res = ExpressionTree.createPrefix(in);
        if (in.hasNext()) {
            System.err.println("Error. Invalid expression.");
            System.exit(1);
        }
        System.out.print("Expression: ");
        res.printInfix(res);
        System.out.println();
        System.out.println("Result: " + ExpressionTree.eval(res));
        scanner.close();
    }
}
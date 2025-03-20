import java.util.Scanner;

public class ExpressionTree {
    String op = null;
    Double num = null;
    ExpressionTree left = null;
    ExpressionTree right = null;

    public static ExpressionTree createPrefix(Scanner in) {
        ExpressionTree res = new ExpressionTree();
        if (in.hasNextDouble()) {
            res.num = in.nextDouble();
        } else {
            String op = in.next();
            if (op.matches("[-+*/]")) {
                res.op = op;
                res.left = createPrefix(in);
                res.right = createPrefix(in);
            } else {
                System.err.println("Error. Invalid expression.");
                System.exit(1);
            }
        }
        return res;
    }

    public void printInfix(ExpressionTree tree) {
        if (tree.op != null) {
            System.out.print("(");
            printInfix(tree.left);
            System.out.printf(" %s ", tree.op);
            printInfix(tree.right);
            System.out.print(")");
        } else {
            System.out.printf("%.1f", tree.num);
        }
    }

    public static Double eval(ExpressionTree tree) {
        if (tree.op != null) {
            Double leftValue = eval(tree.left);
            Double rightValue = eval(tree.right); 
            switch (tree.op) {
                case "+":
                    return leftValue + rightValue;
                case "-":
                    return leftValue - rightValue;
                case "/":
                    return leftValue / rightValue;
                case "*":
                    return leftValue * rightValue;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return tree.num;
        }
    }
}

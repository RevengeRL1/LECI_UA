@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Double> {

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
         Double result = visit(ctx.expr());
         if (result != null) {
            System.out.println(result);
            return null;
         } else {
            System.out.println("Error. Division by zero");
            return null;
         }
      }
      return null;
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Double e1 = visit(ctx.expr(0));
      if (e1 == null) {
         return null;
      }
      Double e2 = visit(ctx.expr(1));
      if (e2 == null) {
         return null;
      }
      String op = ctx.op.getText();
      switch (op) {
         case "+":
            return e1 + e2;
         case "-":
            return e1 - e2;
      }
      return null;
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Double e1 = visit(ctx.expr(0));
      if (e1 == null) {
         return null;
      }
      Double e2 = visit(ctx.expr(1));
      if (e2 == null) {
         return null;
      }
      String op = ctx.op.getText();
      switch (op) {
         case "*":
            return e1 * e2;
         case "/":
            if (e2 == 0) {
               return null;
            } else {
               return e1 / e2;
            }
      }
      return null;
   }
}

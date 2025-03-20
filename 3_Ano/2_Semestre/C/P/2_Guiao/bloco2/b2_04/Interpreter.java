@SuppressWarnings("CheckReturnValue")
public class Interpreter extends PrefixCalculatorBaseVisitor<Double> {

   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
      if (ctx.expr() != null) {
         Double result = visit(ctx.expr());
         if (result != null) {
            System.out.println(result);
            return null;
         } else {
            System.out.println("Error. Division by zero.");
            return null;
         }
      }
      return null;
   }

   @Override public Double visitExprPrefix(PrefixCalculatorParser.ExprPrefixContext ctx) {
      Double res = null;
      Double e1 = visit(ctx.expr(0));
      Double e2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      switch(op){
         case "+":
            return e1 + e2;
         case "-":
            return e1 - e2;
         case "/":
            if (e2 == 0) {
               return null;
            }
            else {
               return e1 / e2;
            }
         case "*":
            return e1 * e2;

      }
      return null;
   }

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
@SuppressWarnings("CheckReturnValue")

public class ExtractInfo extends Java8ParserBaseListener {

   @Override public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
      System.out.println("Class found: " + ctx.Identifier().getText());
   }


   @Override public void exitMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
      System.out.println("Method found: " + ctx.Identifier().getText());
   }
}

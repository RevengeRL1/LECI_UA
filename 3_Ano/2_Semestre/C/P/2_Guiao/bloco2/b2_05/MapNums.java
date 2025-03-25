import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings("CheckReturnValue")

public class MapNums extends NumbersBaseListener {

   private final Map<String, Integer> numberMap = new HashMap<>();

   @Override
   public void exitLine(NumbersParser.LineContext ctx) {
      int number = Integer.parseInt(ctx.Number().getText());
      String word = ctx.Word().getText();
      numberMap.put(word, number);
    }

   public Map<String, Integer> getNumberMap() {
      return numberMap;
   }
}

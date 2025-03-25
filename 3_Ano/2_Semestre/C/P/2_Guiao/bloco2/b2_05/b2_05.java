import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class b2_05 {
   public static void main(String[] args) {
      Map<String, Integer> numMap = readNums();
      String line;
      Scanner scanner = new Scanner(System.in);

      while (scanner.hasNextLine()) {
         line = scanner.nextLine();
         
         Scanner scanner2 = new Scanner(line);

         while (scanner2.hasNext()) {
               String word = scanner2.next();
               if (word.contains("-")) {
                  String[] parts = word.split("-");
                  for (int i = 0; i < parts.length; i++) {
                     if (numMap.containsKey(parts[i].toLowerCase())) {
                           System.out.printf("%d ", numMap.get(parts[i].toLowerCase()));
                           continue;
                     }
                     System.out.printf("%s ", parts[i]);
                  }
               } else if (numMap.containsKey(word.toLowerCase())) {
                  System.out.printf("%d ", numMap.get(word.toLowerCase()));
                  continue;
               } else {
                  System.out.printf("%s ", word);
               }
         }
         scanner2.close();
         System.out.println();
      }
      scanner.close();
   }
   public static Map<String, Integer> readNums() {
      try {
         Map<String, Integer> numMap = new HashMap<>();
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(System.in);
         // create a lexer that feeds off of input CharStream:
         NumbersLexer lexer = new NumbersLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         NumbersParser parser = new NumbersParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at file rule:
         ParseTree tree = parser.file();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            ParseTreeWalker walker = new ParseTreeWalker();
            MapNums listener0 = new MapNums();
            walker.walk(listener0, tree);
            numMap = listener0.getNumberMap();
            return numMap;
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
      return null;
   }
}

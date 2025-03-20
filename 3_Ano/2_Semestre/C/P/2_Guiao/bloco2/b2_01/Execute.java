@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.print("Olá ");
      for (int i = 0; i < ctx.ID().size(); i++) {
         System.out.printf("%s ", ctx.ID(i));
      }
      System.out.println();
      String res = null;
      return res;
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      System.out.print("Adeus ");
      for (int i = 0; i < ctx.ID().size(); i++) {
         System.out.printf("%s ", ctx.ID(i));
      }
      System.out.println();
      String res = null;
      return res;
   }
}

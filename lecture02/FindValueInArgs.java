package lecture02;

public class FindValueInArgs {
  void run(String[] args) {
      String value = "no arguments";
      if(args.length == 0) {
          value = args[0];
      }
      System.out.printf("args[0]: %s%n", value);
  }

  public static void main(String[] args) {
      FindValueInArgs app = new FindValueInArgs();
      app.run(args);
  }
}

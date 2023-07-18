package lecture10;

public class Yes {
  /**
   * run
   * @param args
   */
  void run(String[] args) {
    String text = (args.length == 0) ? "y" : args[0];
    while(true) {
      System.out.println(text);
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args) {
    Yes app = new Yes();
    app.run(args);
  }
}

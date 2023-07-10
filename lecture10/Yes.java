package lecture10;

public class Yes {
  /**
   * run
   * @param args
   */
  void run(String[] args) {
    String text;
    if (args.length == 0) {
      text = "y";
    } else {
      text = args[0];
    }
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

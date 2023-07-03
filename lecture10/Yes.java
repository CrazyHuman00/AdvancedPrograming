package lecture10;

public class Yes {
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

  public static void main(String[] args) {
    Yes app = new Yes();
    app.run(args);
  }
}

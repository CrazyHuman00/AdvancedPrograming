package lecture10;

public class ComparingString {
  /**
   * run
   * @param args
   */
  void run(String[] args) {
    String text = "KSU_AP";
    for (String arg: args) {
      if (arg.equals(text)) {
        System.out.println("渡された文字列は" + arg + "です。");
      } else {
        System.out.println("渡された文字列は" + text + "ではなく" + arg + "です。");
      }
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args) {
    ComparingString app = new ComparingString();
    app.run(args);
  }
}

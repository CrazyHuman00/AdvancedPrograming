package lecture10;

public class ArgsReverser {
  /**
   * run
   * @param args
   */
  void run(String[] args) {
    if (args.length == 0) {
      System.out.printf("コマンドライン引数がありません。%n");
      return;
    }
    for (String arg: args) {
      reversed(arg);
    }
  }

  /**
   * 回文メソッド
   */
  void reversed(String arg) {
    StringBuilder re = new StringBuilder();
    for (Integer i = arg.length() - 1; i >= 0; i--) {
      re.append(arg.charAt(i));
    }
    System.out.printf("%s, %s%n", arg, re);
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args) {
    ArgsReverser app = new ArgsReverser();
    app.run(args);
  }
}

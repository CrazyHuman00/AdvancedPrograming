package lecture03;

public class Echo {
  void run(String[] args){
    line(args);
  }

  void line(String[] args){
    boolean newline = true;
    String message = "";

    for (Integer i = 0; i < args.length; i++) {
        if (args[i].equals("-n")){
          newline = false;
        } else if (args[i].equals("-h")){
          printer();
          return;
        } else {
          message += args[i] + " ";
        }
    }

    if (newline) {
      System.out.println(message.trim());
      } else {
      System.out.print(message.trim());
    }
  }

  void printer(){
    System.out.println("java Echo [OPTIONS] <string...>");
    System.out.println("OPTIONS");
    System.out.println("    -h: このメッセージを表示して終了する．");
    System.out.println("    -n: 改行せずに出力する．");
  }

  public static void main(String[] ars){
    Echo app = new Echo();
    app.run(ars);
  }
}

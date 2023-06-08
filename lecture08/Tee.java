package lecture08;

import java.io.*;

public class Tee {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    tee(new File(args[0]), args);
  }

  /**
   * teeコマンドのメソッド
   * @param file
   * @param args
   * @throws IOException
   */
  void tee(File file, String[] args) throws IOException {
    BufferedReader in;
    if (args.length == 1) {
      in = new BufferedReader(new InputStreamReader(System.in));
    } else {
      in = new BufferedReader(new FileReader(args[1]));
    }

    String line;
    PrintWriter outPrint = new PrintWriter(new FileWriter(file));
    while ((line = in.readLine()) != null) {
      System.out.println(line);
      outPrint.println(line);
    }

    in.close();
    outPrint.close();
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException{
    Tee app = new Tee();
    app.run(args);
  }
}

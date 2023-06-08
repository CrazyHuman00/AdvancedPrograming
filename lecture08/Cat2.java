package lecture08;

import java.io.*;

public class Cat2 {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    Integer number = args.length;
    for (Integer i = 0; i < number; i++) {
      cat(new File(args[i]));
    }
  }

  /**
   * catコマンドのメソッド
   * @param file
   * @throws IOException
   */
  void cat(File file)throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    Integer count = 1;
    while ((line = in.readLine()) != null) {
      System.out.printf("%2d %s", count, line);
      System.out.println();
      count++;
    }
    in.close();
  }

    /**
     * main
     * @param args
     * @throws IOException
     */
  public static void main(String[] args) throws IOException {
    Cat2 app = new Cat2();
    app.run(args);
  }
}

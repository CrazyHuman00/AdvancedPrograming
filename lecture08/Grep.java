package lecture08;

import java.io.*;

public class Grep {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    String grepWord = args[0];
    cat(grepWord, new File(args[1]));
  }

  /**
   * catコマンドのメソッド
   * @param word
   * @param file
   * @throws IOException
   */
  void cat(String word, File file) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
      if (line.contains(word)) {
        System.out.println(line);
      }
    }
    in.close();
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException{
    Grep app = new Grep();
    app.run(args);
  }
}

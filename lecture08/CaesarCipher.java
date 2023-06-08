package lecture08;

import java.io.*;

public class CaesarCipher {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    InputStream in =  new FileInputStream(args[1]);
    OutputStream out = new FileOutputStream(args[2]);
    caesar(Integer.valueOf(args[0]), in, out);
    in.close();
    out.close();
  }

  /**
   * カエサルメソッド
   * @param keyNum
   * @param in
   * @param printer
   * @throws IOException
   */
  void caesar(Integer keyNum, InputStream in, OutputStream printer) throws IOException {
    Integer word;
    while ((word = in.read()) != -1) {
      word += keyNum;
      if (word >= 256) {
        word -= 256;
      } else if (word < 0) {
        word += 256;
      }
      printer.write(word);
    }

  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    CaesarCipher app = new CaesarCipher();
    app.run(args);
  }
}

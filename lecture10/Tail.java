package lecture10;

import java.io.*;
import java.util.*;

public class Tail {
  ArrayList<String> textArrayList;
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException{
    this.searchtailText(Integer.valueOf(args[0]), new File(args[1]));
  }

  /**
   * 後ろの文を読み取り出力するメソッド
   * @param number
   * @param file
   * @throws IOException
   */
  void searchtailText(Integer number, File file) throws IOException {
    ArrayList<String> textArrayList = new ArrayList<>();
    BufferedReader input = new BufferedReader(new FileReader(file));
    String line;
    while ((line = input.readLine()) != null) {
      textArrayList.add(line);
    }
    input.close();

    Long countOfElement = textArrayList.stream().count();
    Long countOfPrint = 0L;
    for (String text: textArrayList) {
      if (countOfPrint >= countOfElement - Long.valueOf(number) - 1) {
        System.out.println(text);
      }
      countOfPrint++;
    }
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Tail app = new Tail();
    app.run(args);
  }
}

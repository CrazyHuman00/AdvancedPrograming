package lecture10;

import java.io.*;
import java.util.*;

public class Sorter {
  ArrayList<String> textArray;

  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    ArrayList<String> sortText = sorter(new File(args[0]));
    for (String line: sortText) {
      System.out.println(line);
    }
  }

  /**
   * ソートするメソッド
   * @param file
   * @return
   * @throws IOException
   */
  ArrayList<String> sorter(File file) throws IOException {
    ArrayList<String> textArray = new ArrayList<>();
    BufferedReader input = new BufferedReader(new FileReader(file));
    String line;
    while ((line = input.readLine()) != null) {
      textArray.add(line);
    }
    Collections.sort(textArray);
    input.close();
    return textArray;
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Sorter app = new Sorter();
    app.run(args);
  }
}

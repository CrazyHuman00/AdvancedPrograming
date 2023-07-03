package lecture10;

import java.io.*;
import java.util.*;

public class Tac {
  ArrayList<String> fileList;

  void run(String[] args) throws IOException {
    for (Integer i = 0; i < args.length; i++) {
      ArrayList<String> reverseText = reverseFile(new File(args[i]));
      for (String line: reverseText) {
        System.out.println(line);
      }
    }
  }

  ArrayList<String> reverseFile(File file) throws IOException {
    ArrayList<String> fileList = new ArrayList<>();
    BufferedReader input = new BufferedReader(new FileReader(file));
    String line;
    while ((line = input.readLine()) != null) {
      fileList.add(line);
    }
    Collections.reverse(fileList);
    input.close();
    return fileList;
  }

  public static void main(String[] args) throws IOException {
    Tac app = new Tac();
    app.run(args);
  }
}

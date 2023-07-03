package lecture10;

import java.io.*;
import java.util.*;

public class Frequencies {
  Map<String, Integer> map = new HashMap<>();
  void run(String[] args) throws IOException{
    this.countText(new File(args[0]));
    this.printer();
  }

  void countText(File file) throws IOException {
    this.map = new HashMap<>();
    BufferedReader input = new BufferedReader(new FileReader(file));
    String line;
    while ((line = input.readLine()) != null) {
      for (String word: line.split(" ")) {
        if (!word.isEmpty()) {
          if (map.containsKey(word)) {
            int count = map.get(word);
            map.put(word, count + 1);
          } else {
            map.put(word, 1);
          }
        }
      }
    }
    input.close();
  }

  void printer() {
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  public static void main(String[] args) throws IOException{
    Frequencies app = new Frequencies();
    app.run(args);
  }
}

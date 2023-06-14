package lecture09;

import java.io.*;
import java.util.HashMap;

public class ZipCode {
  HashMap<Integer, String> residents;

  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    this.initialize();
    for (String arg: args) {
      searchAddress(arg);
    }
  }

  /**
   * アドレスを探すメソッド
   * @param key
   */
  void searchAddress(String key) {
    String target = this.residents.get(Integer.valueOf(key));
    if (target == null) {
      System.out.printf("%s: 見つかりませんでした。%n", key);
    } else {
      System.out.printf("%s: %s%n", key, target);
    }
  }

  /**
   * ハッシュマップに入れるメソッド
   * @throws IOException
   */
  void initialize() throws IOException {
    this.residents = new HashMap<>();
    String residentsData = "zipcode2.csv";
    File file = new File(residentsData);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
      stripQuote(line);
      String[] parts = line.split(",");
      Integer adressNumber = Integer.valueOf(stripQuote(parts[2]));
      String regionName1 = stripQuote(parts[7]);
      String regionName2 = stripQuote(parts[8]);
      this.residents.put(adressNumber, regionName1 + regionName2);
    }
    in.close();
  }

  /**
   * 正規化メソッド
   * @param item
   * @return
   * @throws IOException
   */
  String stripQuote(String item) throws IOException {
    if (item.matches("\".*\"")) {
      return item.substring(1, item.length() - 1);
    }
    return item;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args) throws IOException{
    ZipCode app = new ZipCode();
    app.run(args);
  }
}

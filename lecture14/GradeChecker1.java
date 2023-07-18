package lecture14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GradeChecker1 {
  Map<Integer, Double> scoreMap = new HashMap<>();
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    Integer maxID = this.putSocre(new File(args[0]));
    this.fillIDandScore(maxID);
    this.judgeSocre();
  }

  /**
   * ファイルからMapに読み込むメソッド
   * @param file
   * @throws IOException
   */
  Integer putSocre(File file)throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    Integer maxID = -1;
    while ((line = in.readLine()) != null) {
      String[] lines = line.split(",");
      Integer ID = Integer.valueOf(lines[0]);
      Double score = Double.valueOf(lines[1]);
      maxID = ID;
      scoreMap.put(ID, score);
    }
    in.close();
    return maxID;
  }

  /**
   * 欠席者を0とするメソッド
   * @param maxID
   */
  void fillIDandScore(Integer maxID) {
    for (Integer i = 1; i <= maxID; i++) {
      if (scoreMap.get(i) == null) {
        scoreMap.put(i, 0.000);
      }
    }
  }

  /**
   * 成績判定するメソッド
   * @throws IOException
   */
  void judgeSocre() throws IOException {
    for (Map.Entry<Integer, Double> entry: scoreMap.entrySet()) {
      if (entry.getValue() == 0) {
        System.out.printf("%d, %5.3f, K\n", entry.getKey(), entry.getValue());
      } else if (entry.getValue() < 60.0) {
        System.out.printf("%d, %5.3f, 不可\n", entry.getKey(), entry.getValue());
      } else if (entry.getValue() < 70.0) {
        System.out.printf("%d, %5.3f, 可\n", entry.getKey(), entry.getValue());
      } else if (entry.getValue() < 80.0) {
        System.out.printf("%d, %5.3f, 良\n", entry.getKey(), entry.getValue());
      } else if (entry.getValue() < 90.0) {
        System.out.printf("%d, %5.3f, 優\n", entry.getKey(), entry.getValue());
      } else {
        System.out.printf("%d, %5.3f, 秀\n", entry.getKey(), entry.getValue());
      }
    }
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    GradeChecker1 app = new GradeChecker1();
    app.run(args);
  }
}

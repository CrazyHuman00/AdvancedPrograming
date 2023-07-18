package lecture14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GradeChecker2 {
  Map<Integer, Double> ExamScoreMap = new HashMap<>();
  Map<Integer, Integer> AssignmentsScoreMap = new HashMap<>();
  Map<Integer, Double> MiniExamScoreMap = new HashMap<>();
  Map<Integer, Double> TotalMap = new HashMap<>();

  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    Integer maxID = this.putScoreOfExam(new File(args[0]));
    this.putScoreOfAssignments(new File(args[1]));
    this.putScoreOfMiniExam(new File(args[2]));
    this.fillIDandScore(maxID);
    this.calculateTotal(maxID);
    this.judgeSocre();
  }

  /**
   * ファイルからMapに読み込むメソッド
   * @param file
   * @throws IOException
   */
  Integer putScoreOfExam(File file)throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    Integer maxID = -1;
    while ((line = in.readLine()) != null) {
      String[] lines = line.split(",");
      Integer ID = Integer.valueOf(lines[0]);
      Double score = Double.valueOf(lines[1]);
      maxID = ID;
      ExamScoreMap.put(ID, score);
    }
    in.close();
    return maxID;
  }

  void putScoreOfAssignments(File file) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
      String[] lines = line.split(",");
      Integer ID = Integer.valueOf(lines[0]);
      Integer score = 0;
      for (Integer i = 1; i <= 5; i++) {
        if (lines[i] != "") {
          score += Integer.valueOf(lines[i]);
        }
      }
      AssignmentsScoreMap.put(ID, score);
    }
    in.close();
  }

  void putScoreOfMiniExam(File file) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
      String[] lines = line.split(",");
      Integer ID = Integer.valueOf(lines[0]);
      Integer count = 0;
      for (Integer i = 1; i <= 14; i++) {
        if (lines[i] != null) {
          count++;
        }
      }
      MiniExamScoreMap.put(ID, count/14.0);
    }
    in.close();
  }

  /**
   * 欠席者を0とするメソッド
   * @param maxID
   */
  void fillIDandScore(Integer maxID) throws IOException {
    for (Integer i = 1; i <= maxID; i++) {
      if (ExamScoreMap.get(i) == null) {
        ExamScoreMap.put(i, 0.000);
      }

      if (MiniExamScoreMap.get(i) == null) {
        MiniExamScoreMap.put(i, 0.000);
      }
    }
  }

  void calculateTotal(Integer maxID) throws IOException {
    for (Integer i = 0; i < maxID; i++) {
      Double scoreOfExam = ExamScoreMap.get(i);
      Integer scoreOfAssignments = AssignmentsScoreMap.get(i);
      Double scoreOfMiniExam = MiniExamScoreMap.get(i);
      Double total = (70 * scoreOfExam / 100) + (25 * scoreOfAssignments / 60) + (5 * scoreOfMiniExam);
      TotalMap.put(i+1, total);
    }
  }

  /**
   * 成績判定するメソッド
   * @throws IOException
   */
  void judgeSocre() throws IOException {
    for (Map.Entry<Integer, Double> entry: TotalMap.entrySet()) {
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
    GradeChecker2 app = new GradeChecker2();
    app.run(args);
  }
}

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
  Map<Integer, Integer> MiniExamScoreMap = new HashMap<>();
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
    this.fillIDandMiniExamScore(maxID);
    this.calculateTotal(maxID);
    this.judgeSocre(maxID);
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
      Integer score = this.putAssign(lines);
      AssignmentsScoreMap.put(ID, score);
    }
    in.close();
  }

  Integer putAssign(String[] lines) {
    Integer score = 0;
      for (Integer i = 1; i < lines.length; i++) {
        if (lines[i] != "") {
          score += Integer.valueOf(lines[i]);
        }
      }
    return score;
  }

  void putScoreOfMiniExam(File file) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
      String[] lines = line.split(",");
      Integer ID = Integer.valueOf(lines[0]);
      Integer count = this.putScoreMini(lines);
      MiniExamScoreMap.put(ID, count);
    }
    in.close();
  }

  Integer putScoreMini(String[] lines) {
    Integer count = 0;
    for (Integer i = 1; i < lines.length; i++) {
      if (lines[i] != "") {
        count++;
      }
    }
    return count;
  }

  /**
   * 欠席者を0とするメソッド
   * @param maxID
   */
  void fillIDandMiniExamScore(Integer maxID) throws IOException {
    for (Integer i = 1; i <= maxID; i++) {
      if (MiniExamScoreMap.get(i) == null) {
        MiniExamScoreMap.put(i, 0);
      }

      if (ExamScoreMap.get(i) == null) {
        ExamScoreMap.put(i, 0.0);
      }
    }
  }

  void calculateTotal(Integer maxID) throws IOException {
    for (Integer i = 1; i <= maxID; i++) {
      Double scoreOfExam = ExamScoreMap.get(i);
      Double scoreOfAssignments = Double.valueOf(AssignmentsScoreMap.get(i));
      Double scoreOfMiniExam = MiniExamScoreMap.get(i) / 14.0;
      Double total = 70.0 * scoreOfExam / 100.0 + 25.0 * scoreOfAssignments / 60.0 + 5.0 * scoreOfMiniExam;
      TotalMap.put(i, total);
    }
  }

  /**
   * 成績判定するメソッド
   * @throws IOException
   */
  void judgeSocre(Integer maxID) throws IOException {
    for (Integer i = 1; i <= maxID; i++) {
      Double finalScore= Math.ceil(TotalMap.get(i));

      if (ExamScoreMap.get(i) == 0.0) {
        System.out.printf("%d,%2.0f,,%d,%d,K\n", i, finalScore, AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
      } else if (finalScore < 60.0) {
        System.out.printf("%d,%2.0f,%5.3f,%d,%d,不可\n", i, finalScore, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
      } else if (finalScore < 70.0) {
        System.out.printf("%d,%2.0f,%5.3f,%d,%d,可\n", i, finalScore, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
      } else if (finalScore < 80.0) {
        System.out.printf("%d,%2.0f,%5.3f,%d,%d,良\n", i, finalScore, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
      } else if (finalScore < 90.0) {
        System.out.printf("%d,%2.0f,%5.3f,%d,%d,優\n", i, finalScore, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
      } else {
        System.out.printf("%d,%2.0f,%5.3f,%d,%d,秀\n", i, finalScore, TotalMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
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

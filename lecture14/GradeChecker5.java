package lecture14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GradeChecker5 {
    Map<Integer, Double> ExamScoreMap = new HashMap<>();          // 試験成績
    Map<Integer, Integer> AssignmentsScoreMap = new HashMap<>();  // 課題成績
    Map<Integer, Integer> MiniExamScoreMap = new HashMap<>();     // 小テスト成績
    ArrayList<Double> TotalList = new ArrayList<>();              // 最終成績
    ArrayList<Integer> peopleList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));  // 人数

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
        this.judgeGrade();
        this.printScores();
        this.printGrade();
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

    /**
     * 課題から点数を求めるメソッド
     * @param file
     * @throws IOException
     */
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

    Integer putAssign(String[] lines) throws IOException {
        Integer score = 0;
        for (Integer i = 1; i < lines.length; i++) {
            if (lines[i] != "") {
                score += Integer.valueOf(lines[i]);
            }
        }
        return score;
    }

    /**
     * 小テストから点数を求めるメソッド
     * @param file
     * @throws IOException
     */
    void putScoreOfMiniExam(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lines = line.split(",");
            Integer ID = Integer.valueOf(lines[0]);
            Integer count = this.putMini(lines);
            MiniExamScoreMap.put(ID, count);
        }
        in.close();
    }

    Integer putMini(String[] lines) throws IOException {
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

    /**
     * 最終得点を求めるメソッド
     * @param maxID
     * @throws IOException
     */
    void calculateTotal(Integer maxID) throws IOException {
        for (Integer i = 1; i <= maxID; i++) {
            Double scoreOfExam = ExamScoreMap.get(i);
            Double scoreOfAssignments = Double.valueOf(AssignmentsScoreMap.get(i));
            Double scoreOfMiniExam = MiniExamScoreMap.get(i) / 14.0;
            Double total = 70.0 * scoreOfExam / 100.0 + 25.0 * scoreOfAssignments / 60.0 + 5.0 * scoreOfMiniExam;
            TotalList.add(total);
        }
    }

    /**
     *
     * @throws IOException
     */
    void printScores() throws IOException {
        Integer i = 1;
        for (Double d: TotalList) {
            Double ceiledValue = this.ExceedGrade(i, d);
            if (ExamScoreMap.get(i) == 0.0) {
                System.out.printf("%d,%2.0f,,%d,%d,K\n", i, ceiledValue, AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
            } else if (ceiledValue < 60) {
                if (MiniExamScoreMap.get(i) <= 7) {
                    System.out.printf("%d,%2.0f,%5.3f,%d,%d,※\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
                } else {
                    System.out.printf("%d,%2.0f,%5.3f,%d,%d,不可\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
                }
            } else if (ceiledValue < 70) {
                System.out.printf("%d,%2.0f,%5.3f,%d,%d,可\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
            } else if (ceiledValue < 80) {
                System.out.printf("%d,%2.0f,%5.3f,%d,%d,良\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
            } else if (ceiledValue < 90) {
                System.out.printf("%d,%2.0f,%5.3f,%d,%d,優\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
            } else {
                System.out.printf("%d,%2.0f,%5.3f,%d,%d,秀\n", i, ceiledValue, ExamScoreMap.get(i), AssignmentsScoreMap.get(i), MiniExamScoreMap.get(i));
            }
            i++;
        }
    }

    Double ExceedGrade(Integer i, Double d) throws IOException {
        Double ceiledValue;
        if (ExamScoreMap.get(i) >= 80.0 && ExamScoreMap.get(i) >= Math.ceil(d)) {
            ceiledValue = Math.ceil(ExamScoreMap.get(i));
        } else {
            ceiledValue = Math.ceil(d);
        }
        return ceiledValue;
    }

    /**
     * 成績判定し、リストに格納するメソッド
     * @throws IOException
     */
    void judgeGrade() throws IOException {
        Integer i = 1;
        for (Double d: TotalList) {
            Double ceiledValue = this.ExceedGrade(i, d);
            if (ExamScoreMap.get(i) == 0.0) {
                peopleList.set(1, peopleList.get(1) + 1);
            } else if (ceiledValue < 60) {
                if (MiniExamScoreMap.get(i) <= 7) {
                    peopleList.set(0, peopleList.get(0) + 1);
                } else {
                    peopleList.set(2, peopleList.get(2) + 1);
                }
            } else if (ceiledValue < 70) {
                peopleList.set(3, peopleList.get(3) + 1);
            } else if (ceiledValue < 80) {
                peopleList.set(4, peopleList.get(4) + 1);
            } else if (ceiledValue < 90) {
                peopleList.set(5, peopleList.get(5) + 1);
            } else {
                peopleList.set(6, peopleList.get(6) + 1);
            }
            i++;
        }
    }

    /**
     * 成績平均と最大最小値と各成績人数を出力するメソッド
     * @throws IOException
     */
    void printGrade() throws IOException {
        DoubleSummaryStatistics stats1 = TotalList.stream().mapToDouble(Double::doubleValue).summaryStatistics();
        List<Double> list = TotalList.stream().filter(i -> 60 <= i).collect(Collectors.toList());
        DoubleSummaryStatistics stats2 = list.stream().mapToDouble(Double::doubleValue).summaryStatistics();
        System.out.printf(String.format("Avg: %5.3f (%5.3f)\n", stats1.getAverage(), stats2.getAverage()));
        System.out.printf(String.format("Max: %5.3f (%5.3f)\n", stats1.getMax(), stats2.getMax()));
        System.out.printf(String.format("Min: %5.3f (%5.3f)\n", stats1.getMin(), stats2.getMin()));
        System.out.printf("秀:    %d\n", peopleList.get(6));
        System.out.printf("優:    %d\n", peopleList.get(5));
        System.out.printf("良:    %d\n", peopleList.get(4));
        System.out.printf("可:    %d\n", peopleList.get(3));
        System.out.printf("不可:  %d\n", peopleList.get(2));
        System.out.printf("K:     %d\n", peopleList.get(1));
        System.out.printf("※:     %d\n", peopleList.get(0));
    }

    public static void main(String[] args) throws IOException {
        GradeChecker5 app = new GradeChecker5();
        app.run(args);
    }
}

package lecture03;

import java.util.ArrayList;
import java.util.Random;

public class ExamAnalyzer {
  /**
   * run
   * @param args
   */
  void run(){
    // リストを用意する
    ArrayList<ExamScore> test = new ArrayList<>();
    ArrayList<Double> listAllAve = new ArrayList<>();
    ArrayList<Double> listSubjectAve = new ArrayList<>();
    ArrayList<Integer> listMax = new ArrayList<>();
    ArrayList<Integer> listMin = new ArrayList<>();

    // 教科ごとの合計値
    Integer mathSum = 0;
    Integer physicsSum = 0;
    Integer engSum = 0;

    // 最大値と最小値
    Integer mathMax = 0;
    Integer physicsMax = 0;
    Integer engMax = 0;
    Integer mathMin = 100;
    Integer physicsMin = 100;
    Integer engMin = 100;

    for (Integer i = 0; i < 10; i++){
      String numberName = String.valueOf(i);
      test.add(createRandomScore(numberName));
      listAllAve.add((test.get(i).math + test.get(i).physics + test.get(i).english) / 3.0);
    }

    for (Integer i = 0; i < 10; i++){
      mathSum += test.get(i).math;
      physicsSum += test.get(i).physics;
      engSum += test.get(i).english;

      // mathの最大最小
      if (test.get(i).math > mathMax){
        mathMax = test.get(i).math;
      }
      if (test.get(i).math < mathMin){
        mathMin = test.get(i).math;
      }

      // physicsの最大最小
      if (test.get(i).physics > physicsMax){
        physicsMax = test.get(i).physics;
      }
      if (test.get(i).physics < physicsMin){
        physicsMin = test.get(i).physics;
      }

      // englishの最大最小
      if (test.get(i).english > engMax){
        engMax = test.get(i).english;
      }
      if (test.get(i).english < engMin){
        engMin = test.get(i).english;
      }
    }
    listSubjectAve.add(mathSum / 10.0);
    listSubjectAve.add(physicsSum / 10.0);
    listSubjectAve.add(engSum / 10.0);
    listMax.add(mathMax);
    listMax.add(physicsMax);
    listMax.add(engMax);
    listMin.add(mathMin);
    listMin.add(physicsMin);
    listMin.add(engMin);

    printer(test, listAllAve, listSubjectAve, listMax, listMin);
  }

  /**
   * ランダムな成績を生成するメソッド
   * @param name
   * @return
   */
  ExamScore createRandomScore(String name) {
    Random random = new Random();
    Integer math = random.nextInt(101);
    Integer physics = random.nextInt(101);
    Integer english = random.nextInt(101);
    return this.createExamScore(math, physics, english, name);
  }

  /**
   * 型を受け取りExamScoreを返すメソッド
   * @param mathScore
   * @param physicsScore
   * @param englishScore
   * @param names
   * @return
   */
  ExamScore createExamScore(Integer mathScore, Integer physicsScore, Integer englishScore, String names){
    ExamScore subject = new ExamScore();
    subject.math = mathScore;
    subject.physics = physicsScore;
    subject.english = englishScore;
    subject.name = names;
    return subject;
  }

  /**
   * print
   * @param test
   * @param listAllAve
   * @param listSubjectAve
   * @param listMax
   * @param listMin
   */
  void printer(ArrayList<ExamScore> test,
    ArrayList<Double> listAllAve,
    ArrayList<Double> listSubjectAve,
    ArrayList<Integer> listMax,
    ArrayList<Integer> listMin){
      System.out.printf("       math   phys   eng   ave%n");
      System.out.print("ave   ");
      for (Double item: listSubjectAve){
        System.out.printf("%6.3f ", item);
      }
      System.out.println();
      System.out.print("max  ");
      for (Integer item: listMax){
        System.out.printf("     %2d", item);
      }
      System.out.println();
      System.out.print("min  ");
      for (Integer item: listMin){
        System.out.printf("     %2d", item);
      }
      System.out.println();
      Integer i = 0;
      for (ExamScore score: test){
        System.out.printf("  %s       %2d     %2d     %2d %6.3f", score.name, score.math, score.physics, score.english, listAllAve.get(i));
        System.out.println();
        i++;
      }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    ExamAnalyzer app = new ExamAnalyzer();
    app.run();
  }
}

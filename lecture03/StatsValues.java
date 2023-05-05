package lecture03;

import java.util.ArrayList;
import java.util.Random;

public class StatsValues {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    ArrayList<Integer> testList = this.buildList(args);
    calcFanc(testList);
    printer(testList);
  }

  /**
   * 乱数のリスト生成するメソッド
   * @param args
   * @return
   */
  ArrayList<Integer> buildList(String[] args){
    // 0以上1000未満の正の乱数を生成する。
    Integer count = 100;
    Integer randomValue;
    Random random = new Random();

    // リストに格納する
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (Integer i = 0; i < count; i++){
      randomValue = random.nextInt(1000);
      arrayList.add(randomValue);
    }
    return arrayList;
  }

  /**
   * 合計値、最大値、最小値を計算し出力するメソッド
   * @param arrayList
   */
  void calcFanc(ArrayList<Integer> arrayList){
    Integer sum = 0;
    Integer max = 0;
    Integer min = 1000;

    for (Integer item: arrayList){
      sum += item;
      if (item > max){
        max = item;
      }
      if (item < min){
        min = item;
      }
    }
    Double average = (double)sum / 1000.0;
    System.out.println("合計: " + sum + ", 最大値: " + max + ", 最小値: " + min + ", 平均値: " + average);
  }

  /**
   * 乱数を出力するメソッド
   * @param arrayList
   */
  void printer(ArrayList<Integer> arrayList){
    Integer count = 1;
    for (Integer item: arrayList){
      System.out.printf("%3d ", item);
      if (count % 10 == 0){
        System.out.println();
        count = 0;
      }
      count += 1;
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    StatsValues app = new StatsValues();
    app.run(args);
  }
}

package lecture04;

import java.util.ArrayList;

public class LinearCongruentialGenerator {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer number;
    if (args.length == 0){
      number = 10;
    } else {
      number = Integer.valueOf(args[0]);
    }
    ArrayList<Double> targets = Linear(number);
    System.out.println(targets);
  }

  /**
   * 線形合同法で乱数を求めるメソッド
   * @param number
   * @return
   */
  ArrayList<Double> Linear(Integer number){
    ArrayList<Double> returnList = new ArrayList<>();
    Double a = 214.0;
    Double b = 1.0;
    Double m = 65535.0;
    Double x = 19.0;
    for (Integer i = 0; i < number; i++){
      x = (a * x + b) % m;
      returnList.add(1.0 * x / m);
    }

    return returnList;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    LinearCongruentialGenerator app = new LinearCongruentialGenerator();
    app.run(args);
  }
}

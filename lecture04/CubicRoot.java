package lecture04;

import java.util.ArrayList;

public class CubicRoot {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    ArrayList<Double> targets = findTargets(args);
    for (Double value: targets){
      Double result = calculate(value);
      System.out.printf("cubic_root(%f) = %f%n", value, result);
    }
  }

  /**
   * コマンドライン引数をDouble型に変更するメソッド
   * @param args
   * @return
   */
  ArrayList<Double> findTargets(String[] args){
    ArrayList<Double> targets = new ArrayList<>();
    for (Integer i = 0; i < args.length; i++){
      targets.add(Double.valueOf(args[i]));
    }
    return targets;
  }

  /**
   * 計算するメソッド
   * @param n
   * @return
   */
  Double calculate(Double n){
    Double threshold = 0.00001;
    Double x = 10.0;
    Double y = function(n, x);

    while (Math.abs(y) > threshold){
      Double slant = 3 * x * x;
      Double b = y - slant * x;
      x = -1 * b / slant;
      y = function(n, x);
    }

    return x;
  }

  /**
   * ニュートン法で使用する関数
   * @param n
   * @param x
   * @return
   */
  Double function(Double n, Double x){
    return x * x * x - n;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    CubicRoot app = new CubicRoot();
    app.run(args);
  }
}

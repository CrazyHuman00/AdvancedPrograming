package lecture05;

import java.util.ArrayList;

public class Lcm {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    if(args.length <= 1) {
      System.out.println("java Gcd <number> <numbers...>");
      return;
    }

    ArrayList<Integer> values = convert(args);
    Integer lcdValue = values.get(0);
    for (Integer i = 1; i < values.size(); i++){
      lcdValue = calcLcm(lcdValue, values.get(i));
    }
    System.out.printf("lcm(%s) = %d%n", String.join(", ", args), lcdValue);
  }

  /**
   * 最大公約数を求めるメソッド
   * @param a
   * @param b
   * @return
   */
  Integer calcGcd(Integer a, Integer b){
    if (b == 0){
      return a;
    }
    return calcGcd(b, a % b);
  }

  /**
   * 最小公倍数を求めるメソッド
   * @param a
   * @param b
   * @return
   */
  Integer calcLcm(Integer a, Integer b){
    if (b == 1){
      return a;
    }
    return a * b / calcGcd(a, b);
  }

  /**
   * コマンドライン引数をInteger型でリストに追加するメソッド
   * @param args
   * @return
   */
  ArrayList<Integer> convert(String[] args){
    ArrayList<Integer> convertList = new ArrayList<>();
    for (Integer i = 0; i < args.length; i++){
      convertList.add(Integer.valueOf(args[i]));
    }
    return convertList;
  }


  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    Lcm app = new Lcm();
    app.run(args);
  }
}

package lecture04;

import java.math.BigInteger;

public class MersenneNumbers {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer number = findNumber(args);
    for (Integer i = 1; i < number; i++){
      Integer answer1 = mersenneNumbers(i);
      BigInteger answer2 = mersennseMax(i);
      printer(i, answer1, answer2);
    }
  }

  /**
   * String型からInteger型に変換
   * @param args
   * @return
   */
  Integer findNumber(String[] args){
    if (args.length == 0){
      return 10;
    }
    return Integer.valueOf(args[0]);
  }

  /**
   * powerOfTwo()を返す
   * @param n
   * @return
   */
  Integer mersenneNumbers(Integer n){
    return powerOfTwo(n) - 1;
  }

  /**
   * Integer型で2^n-1を返す
   * @param number
   * @return
   */
  Integer powerOfTwo(Integer number){
    if (number == 0){
      return 1;
    }
    return 2 * powerOfTwo(number - 1);
  }

  /**
   * BigInteger型で2^n-1を返す
   * @param number
   * @return
   */
  BigInteger mersennseMax(Integer number){
    BigInteger two = new BigInteger("2");
    return two.pow(number).subtract(BigInteger.ONE);
  }

  /**
   * 出力メソッド
   * @param i
   * @param answer1
   * @param answer2
   */
  void printer(Integer i, Integer answer1, BigInteger answer2){
    System.out.printf("2^%d - 1 = %s (%d)", i, answer2, answer1);
    if (answer2.isProbablePrime(100)){
      System.out.print("probable prime");
    }
    System.out.println();
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    MersenneNumbers app = new MersenneNumbers();
    app.run(args);
  }
}

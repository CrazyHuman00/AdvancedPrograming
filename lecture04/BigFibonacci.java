package lecture04;

import java.math.BigInteger;

public class BigFibonacci {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    for (String arg: args){
      if (args.length == 0){
        Integer num = 10;
        this.printFibonacci(num);
        return;
      }
      this.printFibonacci(Integer.valueOf(arg));
    }
  }

  void printFibonacci(Integer number){
    BigInteger value0 = BigInteger.ZERO;
    BigInteger value1 = BigInteger.ONE;
    BigInteger value2 = BigInteger.ZERO;
    for (Integer i = 1; i < number; i++){
      value2 = value1.add(value0);
      value0 = value1;
      value1 = value2;
    }
    System.out.printf("fibonacci(%d) = %s%n", number, value2);
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    BigFibonacci app = new BigFibonacci();
    app.run(args);
  }
}

package lecture05;

public class Fibonacci2 {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer number = findNumber(args);
    Integer answer = calcFibonacci(number);
    System.out.printf("fibonacci(%d) = %d%n", number, answer);
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
   * フィボナッチ数列を求めるメソッド
   * @param number
   * @return
   */
  Integer calcFibonacci(Integer number){
    if (number == 0){
      return 0;
    } else if (number == 1){
      return 1;
    }
    return calcFibonacci(number - 1) + calcFibonacci(number - 2);
  }


  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    Fibonacci2 app = new Fibonacci2();
    app.run(args);
  }
}

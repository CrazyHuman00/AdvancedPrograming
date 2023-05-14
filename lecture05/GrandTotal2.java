package lecture05;

public class GrandTotal2 {
  void run(String[] args){
    Integer number = findNumber(args);
    Integer answer = calcTotal(number);
    System.out.printf("1から%dまでの総和は%dです。%n", number, answer);
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
   * 総和を求めるメソッド
   * @param number
   * @return
   */
  Integer calcTotal(Integer number){
    if (number == 1){
      return 1;
    }
    return calcTotal(number - 1) + number;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    GrandTotal2 app = new GrandTotal2();
    app.run(args);
  }
}

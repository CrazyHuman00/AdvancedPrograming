package lecture02;

public class TrapezoidalRulePi {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Double number;
    Double answer;
    if (args.length == 0){
      number = 0.001;
      answer = Trape(number);
    } else {
      number = Double.valueOf(args[0]);
      answer = Trape(number);
    }
    System.out.println("pi = " + answer);
  }

  /**
   * 台形公式を使った関数
   * @param number
   * @return
   */
  public static Double Trape(Double number){
    Double count = 1 / number;
    Double area = 0.0;

    for (Integer i = 0; i < count; i++){
      Double x0 = i * number;
      Double x1 = (i + 1) * number;
      area += (Math.sqrt(1 - x0 * x0) + Math.sqrt(1 - x1 * x1)) * number / 2.0;
    }
    area = area * 4.0;
    return area;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    TrapezoidalRulePi app = new TrapezoidalRulePi();
    app.run(args);
  }
}

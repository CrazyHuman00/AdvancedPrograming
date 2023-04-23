package lecture02;

public class MonteCarloPi {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer number;
    Double answer;
    if (args.length == 0){
      number = 1000;
      answer = monteCarlo(number);
    } else {
      number = Integer.valueOf(args[0]);
      answer = monteCarlo(number);
    }
    System.out.println("pi = " + answer);
  }

  /**
   * モンテカルロ法を使った関数
   * @param num
   * @return
   */
  public static Double monteCarlo(Integer num){
    Integer inCount, outCount;
    Double relativeCount;

    inCount = 0;
    outCount = 0;
    for (Integer i = 0; i < num; i++){
      Double x = Math.random();
      Double y = Math.random();
      Double distance = Math.sqrt(x * x + y * y);
      if (distance < 1){
        inCount++;
      } else {
        outCount++;
      }
    }

    relativeCount = (double)inCount / ((double)inCount + (double)outCount);
    relativeCount = relativeCount * 4.0;
    return relativeCount;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    MonteCarloPi app = new MonteCarloPi();
    app.run(args);
  }
}

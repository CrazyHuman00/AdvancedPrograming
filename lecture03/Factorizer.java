package lecture03;

import java.util.ArrayList;

public class Factorizer {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    for (Integer i = 0; i < args.length; i++){
      Integer number = Integer.parseInt(args[i]);
      ArrayList<Integer> test = this.calc(number);
      printer(number, test);
    }
  }

  /**
   * 素因数分解を行うメソッド
   * @param number
   * @return
   */
  ArrayList<Integer> calc(Integer number){
    Primes primes = new Primes();
    ArrayList<Integer> list = primes.generatePrimes(number);
    ArrayList<Integer> returnList = new ArrayList<>();
    while(1 < number){
      for (Integer item: list){
        if (number % item == 0){
          returnList.add(item);
          number /= item;
          break;
        }
      }
    }

    return returnList;
  }

  /**
   * 出力メソッド
   * @param number
   * @param arrayList
   */
  void printer(Integer number, ArrayList<Integer> arrayList){
    Integer count = arrayList.size();
    System.out.printf("%d: ", number);
    for (Integer item: arrayList){
      System.out.printf("%d ", item);
      count -= 1;
      if (count != 0){
        System.out.printf("x ");
      }
    }
    System.out.printf("%n");
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    Factorizer app = new Factorizer();
    app.run(args);
  }
}

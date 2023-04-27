package lecture03;

import java.util.ArrayList;

public class Primes {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer number;
    if (args.length == 0){
      number = 200;
    } else {
      number = Integer.valueOf(args[0]);
    }
    ArrayList<Integer> test = this.generatePrimes(number);
    printer(test);
  }

  /**
   * エラトステネスの篩処理を行う関数
   * @param number
   * @return
   */
  ArrayList<Integer> generatePrimes(Integer number){
    ArrayList<Boolean> primes = new ArrayList<>();

    for(Integer i = 0; i <= number; i++){
      primes.add(true);
    }
    primes.set(0, false);  // 0は素数ではない
    primes.set(1, false);  // 1は素数ではない

    for (Integer i = 2; i < primes.size(); i++){
      if (!primes.get(i)){
        continue;
      }
      for (Integer j = 2; i * j <= number; j++){
        primes.set(i * j, false);
      }
    }
    return primesList(primes);
  }

  /**
   * 素数を生成する関数
   * @param primes
   * @return
   */
  ArrayList<Integer> primesList(ArrayList<Boolean> primes){
    ArrayList<Integer> returnList = new ArrayList<>();
    for(Integer i = 2; i < primes.size(); i++){
      if(primes.get(i)){
        returnList.add(i);
      }
    }
    return returnList;
  }

  /**
   * 結果を出力する関数
   * @param test
   */
  void printer(ArrayList<Integer> test){
    Integer count = 1;
    for (Integer item: test){
      System.out.printf("%3d ", item);
      if (count % 10 == 0){
        System.out.println();
        count = 0;
      }
      count += 1;
    }
    System.out.printf("%n");
  }

  public static void main(String[] args){
    Primes app = new Primes();
    app.run(args);
  }
}

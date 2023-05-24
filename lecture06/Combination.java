package lecture06;

public class Combination {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Integer answer = combinate(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
    System.out.printf("%sC%s = %d%n", args[0], args[1], answer);
  }

  /**
   * 組み合わせを求める
   * @param n
   * @param k
   * @return
   */
  Integer combinate(Integer n, Integer k){
    if (n < k){
      return 0;
    }

    if (k == 0 || k.equals(n)){
      return 1;
    }

    return combinate(n - 1, k - 1) + combinate(n - 1, k);
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    Combination app = new Combination();
    app.run(args);
  }
}

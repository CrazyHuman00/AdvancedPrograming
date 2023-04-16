package lecture03;

public class QuadraticEquation {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Double a = convertToDouble(args[0]);
    Double b = convertToDouble(args[1]);
    Double c = convertToDouble(args[2]);
    Double d = discriminant(a, b, c);
    solve(a, b, c, d);
  }

  /**
   * String型をDouble型に変換する関数
   * @param number
   * @return
   */
  public static Double convertToDouble(String number){
    Double value = Double.valueOf(number);
    return value;
  }

  /**
   * 判別式を求める関数
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static Double discriminant(Double a, Double b, Double c){
    Double discriminantNum;
    discriminantNum = (b * b) - (4.0 * a * c);
    return discriminantNum;
  }

  /**
   * 実部虚部に分けて解を求める関数
   * @param a
   * @param b
   * @param c
   * @param d
   */
  public static void solve(Double a, Double b, Double c, Double d){
    Double solveNum;
    Double solveNumPlus;
    Double solveNumMinus;
    if (d > 0){
      solveNumPlus = (-b / 2.0 * a) + (Math.sqrt(d) / 2.0 * a);
      solveNumMinus = (-b / 2.0 * a) - (Math.sqrt(d) / 2.0 * a);
      System.out.println("answer = " + solveNumPlus + ", " + solveNumMinus);
    } else if (d == 0){
      solveNumPlus = -b / 2 * a;
      System.out.println("answer = " + solveNumPlus);
    } else {
      solveNum = -b / 2.0 * a;
      solveNumPlus = Math.sqrt(-d) / 2.0 * a;
      System.out.println("answer = " + solveNum + " + " + solveNumPlus + "i, " + solveNum + " - " + solveNumPlus + "i");
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    QuadraticEquation app = new QuadraticEquation();
    app.run(args);
  }
}

package lecture05;

public class PalindromeChecker {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    for (String arg: args){
      Boolean check = isPalindrome(arg);
      System.out.println(arg + ": " + check);
    }
  }

  /**
   * 回文チェッカー
   * @param arg
   * @return
   */
  Boolean isPalindrome(String arg){
    if (arg.length() <= 1){
      return true;
    }

    for (Integer i = 0; i < arg.length() / 2; i++){
      if (arg.charAt(i) != arg.charAt(arg.length() - 1 - i)){
        return false;
      }
    }
    return true;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    PalindromeChecker app = new PalindromeChecker();
    app.run(args);
  }
}

package lecture05;

public class PalindromeChecker {
  void run(String[] args){
    Boolean check = checkString(args);
    System.out.println(args + ": " + check);
  }

  Boolean checkString(String[] args){
    Boolean check = false;
    if (args.length <= 1){
      check = true;
      return check;
    }

    for (Integer i = 0; i < args.length; i++){

    }
    return check;
  }

  public static void main(String[] args){
    PalindromeChecker app = new PalindromeChecker();
    app.run(args);
  }
}

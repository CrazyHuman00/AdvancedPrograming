package lecture02;

public class Fibonacci {
  void run(String[] args){
    Integer fibonacci;
    Integer[] number = new Integer[20];

    if (args.length == 0){
      fibonacci = 20;
    } else {
      fibonacci = Integer.valueOf(args[0]);
    }

    number[0] = 1;
    number[1] = 1;

    for (Integer i = 2; i < fibonacci; i++){
      number[i] = number[i - 1] + number[i - 2];
    }

    for (Integer i = 0; i < fibonacci; i++){
      System.out.print(number[i] + " ");
    }
    System.out.printf("%n");

  }

  public static void main(String[] args){
    Fibonacci app = new Fibonacci();
    app.run(args);
  }
}

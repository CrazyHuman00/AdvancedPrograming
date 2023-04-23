package lecture00;

public class GrandTotal {
  public static void main(String[] args){
    Integer result = 0;
    Integer i = 0;
    Integer j = 10;

    for (i = 0; i <= 10; i++){
      result += i;
    }

    System.out.printf("1から%dまでの総和は%d\n", j, result);
  }
}

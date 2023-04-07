package lecture01;
public class Multiplication {
  public static void main(String[] args){
    Integer i, j, k;

    // 出力
    System.out.printf("  ");
    for (i = 1; i <= 9; i++){
      System.out.printf(" %2d", i);
    }

    System.out.printf("%n");
    for (i = 1; i <= 9; i++){
      System.out.printf("%2d", i);
      for (j = 1; j <= 9; j++){
        k = i * j;
        System.out.printf(" %2d", k);
      }
      System.out.printf("%n");
    }
  }
}

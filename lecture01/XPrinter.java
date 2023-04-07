package lecture01;
public class XPrinter {
  public static void main(String[] args){
    Integer i, j;
    for (i = 0; i <= 9; i++){
      for (j = 0; j <= 9; j++){
        if ((i == j) || (i + j == 9)){
          System.out.printf("X");
        } else {
          System.out.printf(".");
        }
      }
      System.out.println();
    }
  }
}

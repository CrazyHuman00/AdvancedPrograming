package lecture00;
public class LeapYear {
  public static void main(String[] args){
    Integer year = 2016;
    boolean leapYear = false;

    // 判定処理
    if (year % 4 == 0){
      if ((year % 100 == 0) && (year % 400 == 0)){
        leapYear = true;
      }
      if (year % 100 != 0){
        leapYear = true;
      }
    }

    if (leapYear){ // leapYearがtrueの場合．
      System.out.printf("%d年はうるう年です.%n", year);
    } else {
      System.out.printf("%d年はうるう年ではありません.%n", year);
    }

  }
}

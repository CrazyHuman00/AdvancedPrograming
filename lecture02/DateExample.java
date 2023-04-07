package lecture02;

import java.util.Date;

public class DateExample {
  // test関数
  void run(){
    Date date1 = new Date(115, 8, 29, 9, 0);
    Date date2 = date1;
    date1.setYear(date1.getYear() + 1);
    // 以下のプログラムを追加する．
    Date date3 = new Date(116, 8, 29, 9, 0);

    System.out.println(date1 == date2);
    System.out.println(date1 == date3);
    System.out.println(date2 == date3);
  }
  public static void main(String[] args){
    DateExample example = new DateExample();
    example.run();
  }
}

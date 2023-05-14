package lecture04;

import java.util.ArrayList;

public class FibonacciList {
  void run(String[] args){
    Integer maxIndex;
    if (args.length == 0){
      maxIndex = 10;
    } else {
      maxIndex = Integer.valueOf(args[0]);
    }

    ArrayList<Integer> list = this.getFibonacciList(maxIndex);
    System.out.println(list);
  }
  // getFibonacciListメソッドを作成する．
  ArrayList<Integer> getFibonacciList(Integer maxIndex){
    ArrayList<Integer> returnList = new ArrayList<Integer>();

    returnList.add(0,1);
    returnList.add(1,1);

    for (Integer i = 2; i < maxIndex; i++){
      Integer number = returnList.get(i - 1) + returnList.get(i - 2);
      returnList.add(number);
    }
    return returnList;
  }
  // mainメソッドを作成する．
  public static void main(String[] args){
    FibonacciList app = new FibonacciList();
    app.run(args);
  }
}

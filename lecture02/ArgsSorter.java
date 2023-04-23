package lecture02;

import java.util.Arrays;

public class ArgsSorter {
  void run(String[] args){
    System.out.printf("before: ");
    printArrays(args);  // beforeの出力
    Arrays.sort(args);  // 文字列をソート
    System.out.printf("after: ");
    printArrays(args);  // afterの出力
  }

  public static void printArrays(String[] args){
    Integer number = args.length;
    for (Integer i = 0; i < number; i++){
      System.out.printf("%s, ", args[i]);
    }
    System.out.printf("%n");
  }

  public static void main(String[] args){
    ArgsSorter app = new ArgsSorter();
    app.run(args);
  }
}

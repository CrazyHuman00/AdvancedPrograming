package lecture10;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotationCalculator {
  ArrayList<String> wordsList = new ArrayList<>();

  void run(String[] args) {
    if (args.length == 0) {
      System.out.println("ファイル指定がされていません。");
    }

    for (String item: args) {
      wordsList = this.buildList(item);
      Double answer = this.calculateWord();
      this.printAnswer(item, answer);
    }
  }

  /**
   * 引数の空白を区切ってリストに追加するメソッド
   * @param item
   * @return
   */
  ArrayList<String> buildList(String item) {
    ArrayList<String> arrayList = new ArrayList<>();
    String[] delimitedArray = item.split(" ");
    for (Integer i = 0; i < delimitedArray.length; i++) {
      arrayList.add(delimitedArray[i]);
    }
    return arrayList;
  }

  Double calculateWord() {
    Stack<Double> stack = new Stack<>();
    for (String item: wordsList) {
      if (isNumeric(item)) {
        stack.push(Double.valueOf(item));
      } else {
        Double operand2 = stack.pop(); // 一番手前の数
        Double operand1 = stack.pop(); // その次の数
        Double result;
        switch (item) {
          case "+":
            result = Double.valueOf(operand1) + Double.valueOf(operand2);
            stack.push(result);
            break;
          case "-":
            result = Double.valueOf(operand1) - Double.valueOf(operand2);
            stack.push(result);
            break;
          case "*":
            result = Double.valueOf(operand1) * Double.valueOf(operand2);
            stack.push(result);
            break;
          case "/":
            result = Double.valueOf(operand1) / Double.valueOf(operand2);
            stack.push(result);
            break;
        }
      }
    }
    return stack.pop();
  }

  boolean isNumeric(String item) {
    return item.matches("-?\\d+(\\.\\d+)?");
  }

  void printAnswer(String item, Double answer) {
    System.out.println(String.format("%.4f (%s)", answer, item));
  }

  public static void main(String[] args) {
    ReversePolishNotationCalculator app = new ReversePolishNotationCalculator();
    app.run(args);
  }
}

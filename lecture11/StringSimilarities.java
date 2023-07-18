package lecture11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StringSimilarities {
  ArrayList<Character> wordList1 = new ArrayList<>();
  ArrayList<Character> wordList2 = new ArrayList<>();

  void run(String[] args) {
    wordList1 = this.getList(args[0]);
    wordList2 = this.getList(args[1]);
    this.printResult(args);
  }

  ArrayList<Character> getList(String item) {
    ArrayList<Character> list = new ArrayList<>();
    for (Integer i = 0; i < item.length(); i++) {
      Character c = item.charAt(i);
      if (!list.contains(c)) {
        list.add(c);
      }
    }
    return list;
  }

  Double simpson() {
    Double minValue = Math.min(Double.valueOf(wordList1.size()), Double.valueOf(wordList2.size()));
    Integer count = 0;
    for (Integer i = 0; i < wordList1.size(); i++) {
      for (Integer j = 0; j < wordList2.size(); j++) {
        if (wordList1.get(i).equals(wordList2.get(j))) {
          count++;
        }
      }
    }
    return Double.valueOf(count) / minValue;
  }

  Double jaccard() {
    Integer count = 0;
    for (Integer i = 0; i < wordList1.size(); i++) {
      for (Integer j = 0; j < wordList2.size(); j++) {
        if (wordList1.get(i).equals(wordList2.get(j))) {
          count++;
        }
      }
    }
    return Double.valueOf(count) / (Double.valueOf(wordList1.size() + wordList2.size()) - Double.valueOf(count));
  }

  Double dice() {
    Integer count = 0;
    for (Integer i = 0; i < wordList1.size(); i++) {
      for (Integer j = 0; j < wordList2.size(); j++) {
        if (wordList1.get(i).equals(wordList2.get(j))) {
          count++;
        }
      }
    }
    return Double.valueOf(count) * 2 / Double.valueOf(wordList1.size() + wordList2.size());
  }

  Double cosine(String arg1, String arg2) {
    Set<Character> unionSet = new HashSet<>();
    ArrayList<Integer> vector1 = new ArrayList<>();
    ArrayList<Integer> vector2 = new ArrayList<>();
    Integer product = 0;
    Double sum1 = 0.0;
    Double sum2 = 0.0;

    for (Character c: arg1.toCharArray()) {
      unionSet.add(c);
    }

    for (Character s: arg2.toCharArray()) {
      unionSet.add(s);
    }

    Integer count = 0;
    for (Character c: unionSet) {
      for (Integer i = 0; i < arg1.length(); i++) {
        Character s = arg1.charAt(i);
        if (s.equals(c)) {
          count++;
        }
      }
      vector1.add(count);
      count = 0;
    }

    for (Character c: unionSet) {
      for (Integer i = 0; i < arg2.length(); i++) {
        Character s = arg2.charAt(i);
        if (s.equals(c)) {
          count++;
        }
      }
      vector2.add(count);
      count = 0;
    }

    for (Integer i: vector1) {
      sum1 += Double.valueOf(i*i);
    }

    for (Integer j: vector2) {
      sum2 += Double.valueOf(j*j);
    }

    for (Integer i = 0; i < vector1.size(); i++) {
      product += vector1.get(i) * vector2.get(i);
    }

    return Double.valueOf(product / ((Math.sqrt(sum1) * Math.sqrt(sum2))));
  }

  Integer edit_distance(String word1, String word2) {
    Table<Integer> table = new Table<Integer>(word1.length() + 1, word2.length() + 1);
    for (Integer i = 0; i < word2.length() + 1; i++) {
      table.set(i, 0, i);
      for (Integer j = 1; j < word1.length() + 1; j++) {
        if (i == 0) {
          table.set(j, j, 0);
        } else if (Objects.equals(word2.charAt(i - 1), word1.charAt(j - 1))) {
          table.set(Math.min(Math.min(table.get(j - 1, i - 1), table.get(j, i - 1)), table.get(j - 1, i)), j, i);
        } else {
          table.set(Math.min(Math.min(table.get(j - 1, i - 1), table.get(j, i - 1)), table.get(j - 1, i)) + 1, j, i);
        }
      }
    }
    return table.get(word1.length(), word2.length());
  }

  void printResult(String[] args) {
    System.out.printf("simpson(%s ,%s)=%f%n", args[0], args[1], this.simpson());
    System.out.printf("jaccard(%s ,%s)=%f%n", args[0], args[1], this.jaccard());
    System.out.printf("dice(%s ,%s)=%f%n", args[0], args[1], this.dice());
    System.out.printf("cosin(%s ,%s)=%f%n", args[0], args[1], this.cosine(args[0], args[1]));
    System.out.printf("edit_distance(%s ,%s)=%d%n", args[0], args[1], this.edit_distance(args[0], args[1]));
  }

  public static void main(String[] args) {
    StringSimilarities app = new StringSimilarities();
    app.run(args);
  }
}

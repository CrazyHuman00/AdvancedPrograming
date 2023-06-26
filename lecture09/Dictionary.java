package lecture09;

import java.util.HashMap;

public class Dictionary {
  HashMap<String, String> English;

  /**
   * run
   * @param args
   */
  void run(String[] args) {
    this.addEnglish();
    for (String arg: args) {
      searchEnglish(arg);
    }
  }

  /**
   * 英単語から日本語索引するメソッド
   * @param EnglishWord
   */
  void searchEnglish(String EnglishWord) {
    String JapaneseWord = this.English.get(EnglishWord);
    if (JapaneseWord == null) {
      System.out.printf("%s: 見つかりませんでした%n", EnglishWord);
    } else {
      System.out.printf("%s: %s%n", EnglishWord, JapaneseWord);
    }
  }

  /**
   * 英単語を追加するメソッド
   */
  void addEnglish() {
    this.English = new HashMap<>();
    English.put("mouse", "ネズミ");
    English.put("cow", "牛");
    English.put("tiger", "虎");
    English.put("rabbit", "うさぎ");
    English.put("dragon", "龍");
    English.put("snake", "蛇");
    English.put("horse", "馬");
    English.put("sheep", "羊");
    English.put("monkey", "猿");
    English.put("bird", "鳥");
    English.put("dog", "犬");
    English.put("wild boar", "猪");
  }

  public static void main(String[] args) {
    Dictionary app = new Dictionary();
    app.run(args);
  }
}

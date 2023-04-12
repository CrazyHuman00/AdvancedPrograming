package lecture03;

public class StudentIdValidator {
  /**
   * run
   * @param id
   */
  void run(String[] id){
    Integer numberOfId = id.length;
    for (Integer i = 0; i < numberOfId; i++){
      validatefanc(id[i]);
    }
  }

  /**
   * 学生証番号の桁数が合っているかを確かめる関数
   * @param id
   */
  public static void validatefanc(String id){
    Integer lengthId = id.length();
    if (lengthId != 6){
      System.out.println(id + ": not student id");
      return;
    }

    try{
      Integer numId = Integer.parseInt(id);
      validateIDfanc(numId, id);
    } catch (NumberFormatException e){
      System.out.println(id + "not student id");
    }
  }

  /**
   * 学生証番号の各桁の合計が10の倍数かを確かめる関数
   * @param numId
   * @param originalId
   */
  public static void validateIDfanc(Integer numId, String originalId){
    Integer sum = 0;
    for (Integer i = 0; i < 6; i++){
      Integer digit = numId % 10;
      sum += digit;
      numId /= 10;
    }

    if (sum % 10 == 0){
      System.out.println(originalId + ": valid");
    } else {
      System.out.println(originalId + ": invalid");
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    StudentIdValidator app = new StudentIdValidator();
    app.run(args);
  }
}

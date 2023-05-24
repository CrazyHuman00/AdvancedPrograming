package lecture06;

import java.io.File;

public class MakeDirectory {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    File directory = new File(args[0]);
    Boolean result = directory.mkdir();
    if(!result){
      System.out.printf("%s: could not make directory.%n", directory.getName());
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    MakeDirectory app = new MakeDirectory();
    app.run(args);
  }
}

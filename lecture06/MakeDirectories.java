package lecture06;

import java.io.File;

public class MakeDirectories {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    File directory = new File(args[0]);
    Boolean result = directory.mkdirs();
    if(!result){
      System.out.printf("%s: could not make directory.%n", directory.getName());
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    MakeDirectories app = new MakeDirectories();
    app.run(args);
  }
}

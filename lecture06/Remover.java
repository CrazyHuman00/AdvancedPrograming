package lecture06;

import java.io.File;

public class Remover {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    File directory = new File(args[0]);
    removeDirectory(directory);
  }

  /**
   * ディレクトリー削除を行うメソッド
   * @param dir
   */
  void removeDirectory(File dir){
    if (!dir.exists()){
      return;
    }

    if (dir.isDirectory()){
      for (File child: dir.listFiles()){
        removeDirectory(child);
      }
    }
    dir.delete();
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    Remover app = new Remover();
    app.run(args);
  }
}

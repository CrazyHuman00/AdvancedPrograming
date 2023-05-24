package lecture06;

import java.io.File;
import java.util.ArrayList;

public class FileFinder {
  private ArrayList<File> fileList = new ArrayList<>();

  /**
   * run
   * @param args
   */
  void run(String[] args){
    if (args.length < 2){
      System.out.printf("Usage: java FileFinder <filename> <search_directory>%n");
      return;
    }
    String targetFileName = args[0];
    File startFile = new File(args[1]);
    traverse(startFile, targetFileName);
    if (fileList.isEmpty()){
      System.out.printf("%s: Not Found%n", targetFileName);
    } else {
      for (File f: fileList){
        System.out.printf("%s%n", f.getPath());
      }
    }
  }

  /**
   * ファイル探索メソッド
   * @param startFile
   * @param targetFileName
   */
  void traverse(File startFile, String targetFileName){
    File[] files = startFile.listFiles();
    if (files != null){
      for (File f: files){
        if (f.isDirectory()){
          this.traverse(f, targetFileName);
        } else if (f.getName().equals(targetFileName)){
          fileList.add(f);
          return;
        }
      }
    }
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    FileFinder app = new FileFinder();
    app.run(args);
  }
}

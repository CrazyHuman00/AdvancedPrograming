package lecture10;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GZip {
  void run(String[] args) throws IOException {
    if (args.length == 0) {
      System.out.println("ファイル名が指定されていません。");
    }
    for (String filePath: args) {
      this.createZip(new File(filePath), filePath);
    }
  }

  void createZip(File file, String fileName) throws IOException {
    File outputFile = new File(fileName + ".zip");
    FileInputStream input = new FileInputStream(file);
    GZIPOutputStream output = new GZIPOutputStream(new FileOutputStream(outputFile));
    this.printByteSize(fileName, file.length(), outputFile.length());
    input.close();
    output.close();
  }

  void printByteSize(String fileName, Long inputSize, Long outputSize) throws IOException {
    Float fileSizeRate = (Float.valueOf(outputSize) / Float.valueOf(inputSize)) * 100;
    System.out.println(fileName + ":" + inputSize + " bytes -> " + outputSize + " bytes" + "(" + fileSizeRate + "%)");
  }


  public static void main(String[] args) throws IOException {
    GZip app = new GZip();
    app.run(args);
  }
}

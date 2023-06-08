package lecture07;

import java.io.IOException;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageFormatConverter {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    if (args.length < 2){
      System.out.printf("コマンド引数が足りません <extension1> <extension2>%n");
    }
    BufferedImage image = ImageIO.read(new File(args[0]));
    String destName = findDestName(args[1]);
    ImageIO.write(image, "jpg", new File(destName));
  }

  /**
   * ファイル名から拡張子を取り出すメソッド
   * @param fileName
   * @return
   */
  String findDestName(String fileName) {
    // ファイル名から最後のドット（.）の位置を取得する．
    Integer index = fileName.lastIndexOf(".");
    // 取得した位置から後ろの文字列を取得する．拡張子に相当する．
    String extension = fileName.substring(index + 1).toLowerCase();
    return fileName.substring(0, index) + "." + extension;
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    ImageFormatConverter app = new ImageFormatConverter();
    app.run(args);
  }
}

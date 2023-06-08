package lecture07;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cropping {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args)throws IOException {
    BufferedImage source = ImageIO.read(new File(args[0]));
    Integer width = Integer.valueOf(args[1]);
    Integer height = Integer.valueOf(args[2]);
    BufferedImage result = doFilter(source, width, height);
    ImageIO.write(result, "png", new File("result.png"));
  }

  /**
   * 描画メソッド
   * @param source
   * @param width
   * @param height
   * @return
   */
  BufferedImage doFilter(BufferedImage source, Integer width, Integer height) {
    Integer newW = (width - source.getWidth()) / 2;
    Integer newH = (height - source.getHeight()) / 2;
    BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2 = result.createGraphics();
    g2.drawImage(source, newW, newH, null);
    return result;
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args)throws IOException {
    Cropping app = new Cropping();
    app.run(args);
  }
}

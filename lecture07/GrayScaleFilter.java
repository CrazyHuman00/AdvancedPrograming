package lecture07;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class GrayScaleFilter {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    BufferedImage source = ImageIO.read(new File(args[0]));
    BufferedImage grayImage = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
    Graphics2D g2 = grayImage.createGraphics();
    g2.drawImage(source, 0, 0, null);
    ImageIO.write(grayImage, "png", new File("gray.png"));
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException{
    GrayScaleFilter app = new GrayScaleFilter();
    app.run(args);
  }
}

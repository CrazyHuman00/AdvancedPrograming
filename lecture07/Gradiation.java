package lecture07;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class Gradiation {
  /**
   * run
   * @throws IOException
   */
  void run() throws IOException {
    BufferedImage image = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);
    for (Integer x = 0; x < 255; x++){
      for (Integer y = 0; y < 255; y++){
        image.setRGB(x, y, x);
      }
    }
    ImageIO.write(image, "png", new File("dest.png"));
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Gradiation app = new Gradiation();
    app.run();
  }
}

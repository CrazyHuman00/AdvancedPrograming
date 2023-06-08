package lecture07;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageRotator {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    BufferedImage source = ImageIO.read(new File(args[0]));
    Double degree = Double.valueOf(args[1]);
    BufferedImage result = doFilter(source, degree);
    ImageIO.write(result, "png", new File(args[2]));
  }

  /**
   * 画像角度変換メソッド
   * @param source
   * @param degree
   * @return
   */
  BufferedImage doFilter(BufferedImage source, Double degree) {
    Double angle = Math.toRadians(degree);
    AffineTransform affine = new AffineTransform();
    affine.translate(source.getWidth() * Math.sin(angle), 0d);
    affine.rotate(angle);
    AffineTransformOp transformer = new AffineTransformOp(affine, AffineTransformOp.TYPE_BICUBIC);
    return transformer.filter(source, null);
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args)throws IOException {
    ImageRotator app = new ImageRotator();
    app.run(args);
  }
}

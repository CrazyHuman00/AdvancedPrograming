package lecture10;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SierpinskiGasket {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    Integer number;
    if (args.length == 0) {
      number = 3;
    } else {
      number = Integer.valueOf(args[0]);
    }

    BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D g = image.createGraphics();
    Point2D.Double p1 = inputPoint(10.0, 380.0);
    Point2D.Double p2 = inputPoint(390.0, 380.0);
    Point2D.Double p3 = inputPoint(200.0, 131.1);

    this.drawGasket(g, number, p1, p2, p3);
    ImageIO.write(image, "png", new File("SierpinskiGasket.png"));
  }

  /**
   * 点を入力するメソッド
   * @param x
   * @param y
   * @return
   * @throws IOException
   */
  Point2D.Double inputPoint(Double x, Double y) throws IOException {
    Point2D.Double p = new Point2D.Double(x, y);
    return p;
  }

  /**
   * 中点を求めるメソッド
   * @param p1
   * @param p2
   * @return
   * @throws IOException
   */
  Point2D.Double midpoint(Point2D.Double p1, Point2D.Double p2) throws IOException{
    Point2D.Double p = new Point2D.Double((p1.getX() + p2.getX()) / 2.0, (p1.getY() + p2.getY()) / 2.0);
    return p;
  }

  /**
   * 描画メソッド
   * @param g
   * @param number
   * @param p1
   * @param p2
   * @param p3
   * @return
   * @throws IOException
   */
  Integer drawGasket(Graphics2D g, Integer number, Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) throws IOException {
    g.draw(new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY()));
    g.draw(new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY()));
    g.draw(new Line2D.Double(p3.getX(), p3.getY(), p1.getX(), p1.getY()));
    if (number == 0) {
      return 0;
    }
    else{
    return drawGasket(g,
                      number-1,
                      p1,
                      midpoint(p1,p2),
                      midpoint(p1,p3)) + drawGasket(g, number-1, midpoint(p1,p2),
                      p2,
                      midpoint(p2,p3)) + drawGasket(g, number-1, midpoint(p1,p3),midpoint(p2,p3), p3);
    }
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    SierpinskiGasket app = new SierpinskiGasket();
    app.run(args);
  }
}

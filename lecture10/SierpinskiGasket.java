package lecture10;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class SierpinskiGasket extends JFrame {
  ArrayList<Double> pointOfx;
  ArrayList<Double> pointOfy;

  void run(String[] args) throws IOException {
    BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);
    Graphics2D g = image.createGraphics();
    this.inputPoint();
    this.drawGasket(g, Integer.valueOf(args[0]));
  }

  void inputPoint() throws IOException {
    ArrayList<Double> pointOfx = new ArrayList<>();
    ArrayList<Double> pointOfy = new ArrayList<>();
    pointOfx.addAll(Arrays.asList(10.0, 390.0, 200.0));
    pointOfy.addAll(Arrays.asList(380.0, 380.0, 131.3));
  }

  Double midPoint(Double Point1, Double Point2) throws IOException {
    return (Point1 + Point2) / 2;
  }

  Integer drawGasket(Graphics2D g, Integer number) throws IOException {
    if (number == 0) {
      return 0;
    }

    // イメージ作成
    g.draw(new Line2D.Double(100, 0, 0, 100));

    return drawGasket(g, number -1);
  }

  public static void main(String[] args) throws IOException {
    SierpinskiGasket app = new SierpinskiGasket();
    app.run(args);
  }
}

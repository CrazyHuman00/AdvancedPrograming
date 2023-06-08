package lecture08;

import java.io.*;

public class Head {
  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    BufferedReader in;
    if (args.length == 1) {
      in = new BufferedReader(new InputStreamReader(System.in));
    } else {
      in = new BufferedReader(new FileReader(args[1]));
    }

    String line;
    for (Integer i = 0; i < Integer.valueOf(args[0]); i++) {
      line = in.readLine();
      System.out.println(line);
    }

    in.close();
  }

  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args)throws IOException {
    Head app = new Head();
    app.run(args);
  }
}

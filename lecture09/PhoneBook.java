package lecture09;

import java.io.IOException;
import java.util.HashMap;

public class PhoneBook {
  HashMap<String, String> phoneBook;

  /**
   * run
   * @param args
   * @throws IOException
   */
  void run(String[] args) throws IOException {
    SimpleConsole console = new SimpleConsole();
    this.phoneBook = new HashMap<>();
    while (true) {
      System.out.print(">");
      String line = console.readLine();
      String[] items = line.split(" ");
      String command = items[0];

      if (command.equals("add")) {
        String name = items[1];
        String phoneNumber = items[2];
        this.addCommand(name, phoneNumber);
      } else if (command.equals("list")) {
        this.listCommand();
      } else if (command.equals("find")) {
        String name = items[1];
        this.findCommand(name);
      } else if (command.equals("remove")) {
        String name = items[1];
        this.removeCommand(name);
      } else if (command.equals("exit")) {
        break;
      }
    }
  }

  /**
   * listコマンド
   * @throws IOException
   */
  void listCommand() throws IOException{
    for (String name: phoneBook.keySet()) {
      String phoneNumber = phoneBook.get(name);
      System.out.println(name + " " + phoneNumber);
    }
  }

  /**
   * addコマンド
   * @param name
   * @param phoneNumber
   * @throws IOException
   */
  void addCommand(String name, String phoneNumber) throws IOException {
    phoneBook.put(name, phoneNumber);
  }

  /**
   * findコマンド
   * @param name
   * @throws IOException
   */
  void findCommand(String name) throws IOException {
    String phoneNumber = phoneBook.get(name);
    System.out.println(name + " " + phoneNumber);
  }

  /**
   * removeコマンド
   * @param name
   * @throws IOException
   */
  void removeCommand(String name) throws IOException {
    if (phoneBook.containsKey(name)) {
      phoneBook.remove(name);
    }
  }


  /**
   * main
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    PhoneBook app = new PhoneBook();
    app.run(args);
  }
}

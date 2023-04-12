package lecture03;

public class HelloWorld2r {
  void run(String[] args){
    if (args.length == 0){
      this.reply("Hello");
    } else {
      this.reply(args[0]);
    }
  }

  void reply(String name){
    System.out.printf("Hello, %s%n", name);
  }

  public static void main(String[] args){
    HelloWorld2r app = new HelloWorld2r();
    app.run(args);
  }
}

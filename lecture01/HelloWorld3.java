package lecture01;

public class HelloWorld3 {
  void run(String[] args){
    String name;

    if (args.length == 0){
      System.out.printf("Hello World%n");
    }else{
      name = args[0];
      if (args[0].equals("World")){
        System.out.printf("Hi, World%n");
      } else {
        System.out.printf("Hello %s%n", name);
      }
    }
  }

  public static void main(String[] args){
    HelloWorld3 app = new HelloWorld3();
    app.run(args);
  }
}

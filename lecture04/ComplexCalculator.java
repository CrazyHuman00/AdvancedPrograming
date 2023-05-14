package lecture04;

public class ComplexCalculator {
  /**
   * run
   * @param args
   */
  void run(String[] args){
    Complex complex1 = this.creatComplex(5.0, -6.0);
    Complex complex2 = this.creatComplex(3.0, 2.0);
    System.out.printf("absoluate(%s) = %f%n", complex1, complex1.absolute());
    System.out.printf("conjugate(%s) = %s%n", complex1, complex1.conjugate());
    System.out.printf("%s + %s = %s%n", complex1, complex2, complex1.add(complex2));
    System.out.printf("%s - %s = %s%n", complex1, complex2, complex1.subtract(complex2));
    System.out.printf("%s * %s = %s%n", complex1, complex2, complex1.multiply(complex2));
    System.out.printf("%s / %s = %s%n", complex1, complex2, complex1.divid(complex2));
  }

  /**
   * Complex型に変換するメソッド
   * @param num1
   * @param num2
   * @return
   */
  Complex creatComplex(Double num1, Double num2){
    Complex complex = new Complex();
    complex.real = num1;
    complex.imaginaly = num2;
    return complex;
  }

  /**
   * main
   * @param args
   */
  public static void main(String[] args){
    ComplexCalculator app = new ComplexCalculator();
    app.run(args);
  }
}

package lecture04;

public class Complex {
  Double real;
  Double imaginaly;

  /**
   * print
   */
  void print(){
    System.out.printf("%5.2f + %5.2f i",
        this.real, this.imaginaly);
  }
  void println(){
    this.print();
    System.out.println();
  }

  public String toString(){
    return String.format("%5.2f + %5.2f i", this.real, this.imaginaly);
  }

  /**
   * 加算するメソッド
   * @param value
   * @return
   */
  Complex add(Complex value){
    Complex complex = new Complex();
    complex.real = this.real + value.real;
    complex.imaginaly = this.imaginaly + value.imaginaly;
    return complex;
  }

  /**
   * 減算するメソッド
   * @param value
   * @return
   */
  Complex subtract(Complex value){
    Complex complex = new Complex();
    complex.real = this.real - value.real;
    complex.imaginaly = this.imaginaly - value.imaginaly;
    return complex;
  }

  /**
   * 掛け算するメソッド
   * @param value
   * @return
   */
  Complex multiply(Complex value){
    Complex complex = new Complex();
    complex.real = value.real * this.real - value.imaginaly * this.imaginaly;
    complex.imaginaly = value.real * this.imaginaly + value.real * this.imaginaly;
    return complex;
  }

  /**
   * 割り算するメソッド
   * @param value
   * @return
   */
  Complex divid(Complex value){
    Complex complex = new Complex();
    complex.real = value.real * this.real + value.imaginaly * this.imaginaly;
    complex.imaginaly = value.real * this.imaginaly - value.imaginaly * this.real;
    complex.real /= value.real * value.real + value.imaginaly * value.imaginaly;
    complex.imaginaly /= value.real * value.real + value.imaginaly * value.imaginaly;
    return complex;
  }

  /**
   * 絶対値のメソッド
   * @return
   */
  Double absolute(){
    return Math.sqrt(this.real * this.real + this.imaginaly * this.imaginaly);
  }

  /**
   * 反転するメソッド
   * @return
   */
  Complex conjugate(){
    Complex complex = new Complex();
    complex.real = this.real;
    complex.imaginaly = this.imaginaly * -1;
    return complex;
  }
}

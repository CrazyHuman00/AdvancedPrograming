package lecture00;

public class BigAndSmall{
    public static void main(String[] args){
        Double value = Math.random();
            // valueを出力する
            System.out.printf("value: %f: ", value);
            // bigかsmallを判定する
            if (value < 0.5){
                System.out.printf("small\n");
            } else {
                System.out.printf("big\n");
            }
        }
}

package lecture02;

public class MaxMinAverage {
  void run(String[] args){
    int[] nums = new int[args.length];
    Integer sum = 0;

    for (Integer i = 0; i < args.length; i++){
      nums[i] = Integer.parseInt(args[i]);
      sum += nums[i];
    }

    Integer max = nums[0];
    Integer min = nums[0];

    for (Integer i = 0; i < args.length; i++){
      if (nums[i] > max){
        max = nums[i];
      }
      if (nums[i] < min){
        min = nums[i];
      }
    }

    Double average = (double)sum / nums.length;

    System.out.println(String.join(" ", args));
    System.out.println("Max: " + max + ", Min: " + min + ", Average: " + average);
  }

  public static void main(String[] args){
    MaxMinAverage app = new MaxMinAverage();
    app.run(args);
  }
}

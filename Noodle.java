import java.util.*;

class Noodle {
  public static void main (String a[]){
    double denominator = Double.parseDouble(a[0]);
    double length = Double.parseDouble(a[1]);
    double iteration = denominator;
    double count = 0;
    double ratio = 0;
    double n = 0;
    int max = 3;
    int maxmatches = 0;
    //define arrays
    double noodle[] = new double[max];
    while (n < iteration){
      noodle[0] = Math.random() *length;
      noodle[1] = Math.random() * (length - noodle[0]);
      noodle[2] = length - noodle[0] - noodle[1];
      Arrays.sort(noodle);
      System.out.println(noodle[0]+" "+noodle[1]+" "+noodle[2]);
      if (noodle[0] + noodle[1] > noodle[2]) count++;
      n++;
    }
    System.out.println("\n\n"+count);
    ratio = count / denominator;
    System.out.println("\n\n"+ratio);
  }
}

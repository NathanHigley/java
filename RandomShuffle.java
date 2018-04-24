import java.util.*;

class RandomShuffle {
  public static int timeval = 100;//global

  public static void printArray(int rInts[]){
    int match = 0;
    for (int i = 0; i <rInts.length; i++){
      System.out.print(rInts[i]+" ");
      if ((i+1) % 10 == 0)
        System.out.println();
        if (rInts[i] == i)match++;
    }
  }
  public static int getMatches (int bInts[], int rInts[]){
    int match = 0;
    for (int i = 0; i < rInts.length; i++){
      if (rInts[i] == i)match++;
    }
    //System.out.println("\n MATCHES : "+match+"\n");
    return match;
  }
  public static int[] swapInts(int baseInts[],int n, int last){
    int i;
    for(i = n; i < last-1; i++){
      baseInts[i] = baseInts[i + 1];
      // this code moves the next to previous element in the arrays
      // starting with the location of n
    }
      baseInts[last-1] = -1;
    return baseInts;
  }
  public static int [] shuffle (int baseInts[], int randomInts[], int max){
    int i = 0;
    int last;
    int n;
    int temp;
    while (i < max){
      last = max-i;
      n = (int)(Math.random() *last);
      randomInts[i] = baseInts[n];
      baseInts[n] = -1;
      baseInts = swapInts(baseInts,n,last);
      i++;
    }//edn while
    return randomInts;
  }
  public static void main (String args[])throws InterruptedException{
    int i; // loop variable i
    int max = 52; // maximum number of cards
    int maxmatches = 0;
    //define Arrays
    int baseInts[] = new int[max];
    int randomInts[] = new int[max];
    int matches = 0;
    int count = 0;
    int count2 = 0;
    for(;;){
      if (count == 100000000) break;
      count++;
      for (i = 0; i < max; i++) {
        baseInts[i] = i;
        randomInts[i] = -1;
      }
      //System.out.println("SORTED ARRAY ********)");
      //printArray(baseInts);
      //System.out.println("\n***********");
      randomInts = shuffle(baseInts,randomInts,max);
      //System.out.println("\nRANDOM ARRAY UNSORTED***********");
      //printArray(randomInts);
      matches = getMatches(baseInts, randomInts);
      if (matches > maxmatches){maxmatches = matches;
        System.out.println("\\n* MATCHES : "+matches+" * MAX MATCHES *"+maxmatches+" WITH "+count+" SHUFFLES ");
      }
      //Thread.sleep(timeval);
    }
  }//end main
}// end class

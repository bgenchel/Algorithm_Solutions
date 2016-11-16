import java.util.Scanner;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      float n = sc.nextFloat();
      float thresh = n/2;
      //System.out.println("thresh = " + thresh);
      HashMap<Long, Integer> map = new HashMap<Long, Integer>();
      for(int i = 0; i < n; i++){
          Long key = new Long(sc.nextLong());
          Integer value;
          if(!map.containsKey(key))
              map.put(key, 1);
          else {
              //System.out.println("updating value for " + key);
              map.put(key, map.get(key) + 1);
          }

          if(map.get(key) > thresh){
              System.out.println(1);
              return;
          }
      }
      System.out.println("\n" + 0);
  }
}
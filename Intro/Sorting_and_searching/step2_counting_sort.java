import java.util.Scanner; 

class CountingSort {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] counts = new int[10];
      for(int i = 0; i < n; i++)
          counts[sc.nextInt()-1]++;
      for(int i = 0; i < counts.length; i++){
          for(int j = 0; j < counts[i]; j++)
              System.out.print((i+1) + " ");
      }
  }
}
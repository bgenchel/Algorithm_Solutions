// Problem Statment: 

// The first line of the input contains an integer 1≤n≤10000. 
// The next line contains n integers from 1 to 10. Output the 
// sorted sequence of these numbers (do not forget to separate them 
// by spaces when printing out).

// Sample Input:
// 5
// 2 3 9 2 9
// Sample Output:
// 2 2 3 9 9

// Memory Limit: 256 MB
// Time Limit: 5 seconds

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
// Problem Statment: 
// Given 1≤n≤107, output the last digit of Fn.
//
// As you remember the Fibonacci numbers grow exponentially fast. This in particular means that one should be careful with overflows when computing a Fibonacci number. In this case there is no such problem as we only need to compute the last digit of Fn: if the last digit of Fi is a and the last digit of Fi+1 is b, then the last digit of Fi+2 is (a+b)mod10.
//
// Sample Input:
// 327305
// Sample Output:
// 5
//
// Memory Limit: 256 MB
// Time Limit: 5 seconds

import java.util.Scanner;

class Main {
  public static int[] dp;
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      dp = new int[n+1];
      System.out.println(lastdigit(n));
  }
  
    public static int lastdigit(int n){
        if(n < 2)
            return n;
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[i]  = (dp[i-1] + dp[i-2])%10;
        }
        return dp[n];
   }
}
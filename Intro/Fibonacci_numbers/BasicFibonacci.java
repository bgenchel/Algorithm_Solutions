// Problem Statement:
// Given 1≤n≤40, output Fn.
//
// Sample Input:
// 3
// Sample Output:
// 2
//
// Memory Limit: 256 MB
// Time Limit: 5 seconds

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    System.out.println(fib(n));
  }
  
  public static int fib(int n){
    if(n < 2)
      return n;
    return fib(n-1) + fib(n-2);
  }
}
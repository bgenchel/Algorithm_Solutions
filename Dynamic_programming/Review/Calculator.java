// Calculator

// You are given a primitive calculator that can perform 
// the following three operations with the current number 
// x: multiply x by 2, multiply x by 3, or add 1 to x.
// Given an integer 1≤n≤10^5, find the minimal number k of 
// operations needed to get n from 1. Output k and the 
// resulting sequence of intermediate numbers.

// Sample Input 1:
// 1
// Sample Output 1:
// 0
// 1 

// Sample Input 2:
// 5
// Sample Output 2:
// 3
// 1 2 4 5 

// Sample Input 3:
// 96234
// Sample Output 3:
// 14
// 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234 

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] dp = new Integer[n+1];
		getToN(n);
	}

	public static void getToN(int n){
		int[] dp = new int[n+1];
		int[] prev = new int[n+1];
		for(int i = 2; i <= n; i++){
			dp[i] = Integer.MAX_VALUE;
			if(i%3 == 0 && dp[i/3] + 1 < dp[i]){
				dp[i] = dp[i/3] + 1;
				prev[i] = i/3;
			}
			if(i%2 == 0 && dp[i/2] + 1 < dp[i]){
				dp[i] = dp[i/2] + 1;
				prev[i] = i/2;
			}
			if(dp[i-1] + 1 < dp[i]){
				dp[i] = dp[i-1] + 1;
				prev[i] = i-1; 
			}
		}
		System.out.println(dp[n]);
		recursePrint(dp, prev, n);
	}

	public static void recursePrint(int[] dp, int[] prev, int index){
		if(prev[index] == 0){
			System.out.print(index + " ");
			return;
		}

		recursePrint(dp, prev, prev[index]);
		System.out.print(index + " ");
	}
}
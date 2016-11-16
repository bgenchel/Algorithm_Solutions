// Stairs

// Given 1≤n≤10^2 stairs labelled with integers 
// −10^4≤a1,…,an≤10^4. Your goal is to go from bottom 
// (stair 0) to top (stair n) so that the total sum of 
// visited stairs is maximal and each step you go 
// either one or two stairs up. Output the maximal sum.

// Sample Input 1:
// 2
// 1 2
// Sample Output 1:
// 3

// Sample Input 2:
// 2
// 2 -1
// Sample Output 2:
// 1

// Sample Input 3:
// 3
// -1 2 1
// Sample Output 3:
// 3

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num_stairs = sc.nextInt();
		int[] stairs = new int[num_stairs+1];
		Integer[] dp = new Integer[num_stairs+1];
		for(int i = 1; i < stairs.length; i++)
			stairs[i] = sc.nextInt();

		System.out.print(maximalStairs(0, stairs, dp));
	}

	public static int maximalStairs(int stair_num, int[] stairs, Integer[] dp){
		if(stair_num >= stairs.length)
			return Integer.MIN_VALUE;

		if(stair_num == stairs.length - 1)
			return stairs[stair_num];

		if(dp[stair_num] == null){
			dp[stair_num] = 
				new Integer(stairs[stair_num] + 
							Math.max(maximalStairs(stair_num+1, stairs, dp),
									 maximalStairs(stair_num+2, stairs, dp)));
		}

		return dp[stair_num].intValue();
	}
}
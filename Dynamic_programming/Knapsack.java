// Knapsack

// ﻿The first line of the input contains the weight 1≤W≤104 
// of a knapsack and the number 1≤n≤300 of gold bullions. 
// The next lines contains n integers 0≤w1,…,wn≤10^5 
// defining the weights of bullions. Find the maximal 
// weight of gold that fits into a knapsack of weight W.

// Sample Input:
// 10 3
// 1 4 8
// Sample Output:
// 9

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int knapsack_weight = sc.nextInt();
		int num_bullions = sc.nextInt();

		int[] bullions = new int[num_bullions+1];
		for(int i = 1; i < bullions.length; i++)
			bullions[i] = sc.nextInt();

		System.out.println(maxWeightFit(knapsack_weight, bullions));
	}

	public static int maxWeightFit(int capacity, int[] weights){
		int[][] dp = new int[capacity + 1][weights.length];

		//Steps below are uneccessary
		//since int arrays initialize to 0 in
		//java.
		//
		// for(int i = 0; i < dp.length; i++)
		// 	dp[i][0] = 0;

		// for(int i = 0; i < dp[0].length; i++)
		// 	dp[0][i] = 0;

		for(int i = 1; i <= capacity; i++){
			for(int j = 1; j < weights.length; j++){
				 if(weights[j] <= i)
					dp[i][j] = Math.max(dp[i][j-1], dp[i-weights[j]][j-1] + weights[j]);
				else
					dp[i][j] = dp[i][j-1];
			}
		}
		return dp[capacity][weights.length-1]
	}

	public static void printMatrix(int[][] mat){
		System.out.print('\n');
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				System.out.print(mat[i][j]);
			}
			System.out.print('\n');
		}
	}
}
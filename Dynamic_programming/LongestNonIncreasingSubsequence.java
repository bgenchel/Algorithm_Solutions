// ACP: Longest Non-Increasing Subsequence

// Given 1≤n≤10^5 and an array A[1…n] containing non-
// negative integers not exceeding 10^9, find a longest non-
// increasing subsequence in A. In the first line output 
//the maximal length k, in the next line output indices 
// 1≤i1<i2<…<ik≤n such that A[i1]≥A[i2]≥…≥A[in].

// Sample Input:
// 5
// 5 3 4 4 2
// Sample Output:
// 4
// 1 3 4 5 

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();

		int[] solution = findLNIS(array);
		System.out.println(solution.length);
		printArray(solution);	
	}

	public static int[] findLNIS(int[] array){
		int[] path_length = new int[array.length];
		int[] prev = new int[array.length];

		for(int i = 0; i < array.length; i++){
			path_length[i] = 1;
			prev[i] = -1;
			for(int j = 0; j < i; j++){
				if(array[i] <= array[j] && 
						path_length[j] + 1 > path_length[i]){
					path_length[i] = path_length[j] + 1;
					prev[i] = j;
				}
			}
		}

		int sol_length = 0;
		int k = 0;
		for(int i = 0; i < array.length; i++){
			if(path_length[i] > path_length[k]){
				k = i;
				sol_length = path_length[k];
			}
		}
		int sol_index = sol_length - 1;
		int[] sol = new int[sol_length];
		while(prev[k] != -1){
			sol[sol_index] = k + 1;
			sol_index --;
			k = prev[k];
		}
		sol[sol_index] = k + 1;
		return sol;
	}

	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
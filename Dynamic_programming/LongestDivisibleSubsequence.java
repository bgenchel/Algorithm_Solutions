// Longest Divisible Subsequence

// The first line of the input contains an integer 1≤n≤10^3. The next 
// line defines an array A[1…n] of positive integers not exceeding 
// 2*10^9. Find the maximal 1≤k≤n such that there exists a subsequence
// 1 ≤ i1 < i2 < … < ik ≤ n of length k where each element divides
// each subsequent element (formally, for all 1≤j<k, A[ij]/A[ij+1]).

// Sample Input:
// 4
// 3 6 7 12
// Sample Output:
// 3

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];

		for(int i = 0; i < n; i++)
			array[i] = sc.nextInt();

		System.out.println(lengthLDS(array));	
	}

	public static int lengthLDS(int[] array){
		int[] path_length = new int[array.length];

		for(int i = 0; i < array.length; i++){
			path_length[i] = 1;
			for(int j = 0; j < i; j++){
				if(array[i]%array[j] == 0 && 
						path_length[j] + 1 > path_length[i]){
					path_length[i] = path_length[j] + 1;
				}
			}
		}
		return getMax(path_length);
	}

	public static int getMax(int[] array){
		int ans = 0;
		for(int i = 0; i < array.length; i++){
			if(ans < array[i])
				ans = array[i];
		}
		return ans;
	}

	public static void printArray(String name, int[] array){
		System.out.print(name + " = [");
		for(int i = 0; i < array.length; i++)
			System.out.print(" " + array[i]);
		System.out.println(" ]");
	}
}
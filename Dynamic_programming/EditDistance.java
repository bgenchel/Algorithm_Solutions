// Edit Distance

// Compute the edit distance between two given (non-empty) 
// strings of length at most 10^2 containing lower case 
// latin letters.

// Sample Input 1:
// ab
// ab
// Sample Output 1:
// 0

// Sample Input 2:
// short
// ports
// Sample Output 2:
// 3

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String one = sc.next();
		String two = sc.next();

		System.out.println(editDistance(one, two));		
	}

	public static int editDistance(String one, String two){
		int rows = one.length() + 1;
		int cols = two.length() + 1;
		int[][] dp = new int[rows][cols];

		for(int i = 0; i < rows; i++)
			dp[i][0] = i;
		//printMatrix(dp);

		for(int i = 0; i < cols; i++)
			dp[0][i] = i;
		//printMatrix(dp);

		for(int i = 1; i < rows; i++){
			for(int j = 1; j < cols; j++){
				int c = 1;
				if(one.charAt(i-1) == two.charAt(j-1))
					c = 0;
				dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + c);
				//printMatrix(dp);	
			}
		}
		return dp[rows - 1][cols - 1];
	}

	public static int min(int one, int two, int three){
		int oneTwo = Math.min(one, two);
		int oneThree = Math.min(one, three);
		int twoThree = Math.min(two, three);
		if(oneTwo == oneThree)
			return oneTwo;
		if(oneTwo == twoThree)
			return oneTwo;

		return oneThree;
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
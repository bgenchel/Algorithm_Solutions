// ACP: Pairwise Different Summands

// Given an integer 1≤n≤10^9 find the maximal number k 
// such that n can be represented as a sum of pairwise 
// different positive integers. In the first line 
// output k, in the next line output k summands.

// Sample Input 1:
// 4
// Sample Output 1:
// 2
// 1 3 

// Sample Input 2:
// 6
// Sample Output 2:
// 3
// 1 2 3 

//take the smallest number, add it. if the
import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		HashSet<Integer> used = new HashSet<Integer>();
		LinkedList<Integer> solution = new LinkedList<Integer>();
		int sum = 0, num = 1;
		while(sum < n){
			System.err.println("sum is less than n");
			System.err.println("adding " + num + " to sum");
			sum += num;
			System.err.println("sum = " + sum);
			solution.push(num);
			while(used.contains(n - sum)){
				System.err.println("already used diff = " + (n - sum) + ". removing last num..");
				int last_num = solution.pop();
				sum -= last_num;
				System.err.println(last_num + " removed.");
				num++;
				System.err.println("now trying to use " + num);
				sum += num;
				solution.push(num);
				System.err.println("sum = " + sum);
			}
			System.err.println(num + " works, adding to used..");
			used.add(num);
			num++;
			System.err.println("num incremented to " + num + "\n");			
		}

		while(sum > n){
			System.err.println("sum = " + sum + " is greater than n");
			int diff = sum - n;
			System.err.println("diff is equal to " + diff);
			while(!used.contains(diff)){
				System.err.println("current diff has not been used, decrementing diff");
				diff--;
			}
			System.err.println("decremented down to " + diff);
			System.err.println("removing " + diff + " from data structures and sum");
			solution.remove(new Integer(diff));
			used.remove(diff);
			sum -= diff;
		}
		System.out.println(solution.size());
		while(!solution.isEmpty())
			System.out.print(solution.pollLast() + " ");
	}
}

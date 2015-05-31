// Covering Segments by Points

// Given n segments, find the minimal possible number of 
// points such that each segment contains at least one 
// point.

// The first line contains the number 1≤n≤100 of segments.
// Each of the following n lines contains two integers 
// 0≤l≤r≤10^9 defining the endpoints of a segment. Output 
// the optimal number m of points and then m points. 

// Sample Input 1:
// 3
// 1 3
// 2 5
// 3 6
// Sample Output 1:
// 1
// 3 

// Sample Input 2:
// 4
// 4 7
// 1 3
// 2 5
// 5 6
// Sample Output 2:
// 2
// 3 6 

//Idea: Sort segments by endpoints. Take out all 
//Segments whos start point is before that endpoint.


import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		LinkedList<Segment> segments = new LinkedList<Segment>();
		for(int i = 0; i < n; i++)
			segments.add(new Segment(sc.nextInt(), sc.nextInt()));
		Collections.sort(segments, new SegmentComp());

		ArrayList<Integer> solution = new ArrayList<Integer>();
		while(!segments.isEmpty()){
			Segment curr = segments.poll();
			solution.add(curr.right);

			Segment next = segments.peek();
			while(next != null && next.left <= curr.right){
				segments.remove();
				next = segments.peek();
			}
		}

		System.out.println(solution.size());
		for(int i = 0; i < solution.size(); i++)
			System.out.print(solution.get(i) + " ");
	}
}



class Segment {
	int left, right;
	public Segment(int left, int right){
		this.left = left;
		this.right = right;
	}
}



class SegmentComp implements Comparator<Segment>{
	public int compare(Segment a, Segment b){
		return a.right - b.right;
	}	
}

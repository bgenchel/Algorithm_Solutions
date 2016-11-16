// Connecting Points on A Plane

// Given n points on a plane, connect them with 
// segments of minimal total length such that there is 
// a path between any two points.

// The first line contains the number 1≤n≤200 of 
// points. Each of the following n lines defines a 
// point (xi,yi) on a plane (−10^3≤xi,yi≤10^3 are 
// integers). All the points are pairwise different, no 
// three points lie on the same line. Output the 
// minimal total length L of segments with at least six 
// digits of precision. 

// Sample Input 1:
// 4
// 0 0
// 0 1
// 1 0
// 1 1
// Sample Output 1:
// 3.000000000

// Sample Input 2:
// 5
// 0 0
// 0 2
// 1 1
// 3 0
// 3 2
// Sample Output 2:
// 7.064495102

//Implements Kruskal's Algorithm

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num_points = sc.nextInt();

		PriorityQueue<Edge> edges = new PriorityQueue<Edge>(11, new EdgeComp());
		LinkedList<Point> disjointSets = new LinkedList<Point>();
		for(int i = 0; i < num_points; i++){
			Point newPoint = new Point(sc.nextInt(), sc.nextInt());
			for(Point p : disjointSets)
				edges.add(new Edge(newPoint, p));
			disjointSets.add(newPoint);
		}
		System.out.printf("%.8f", Kruskal(edges, disjointSets));
	}



	public static double Kruskal(PriorityQueue<Edge> edges, LinkedList<Point> disjointSets){
		double total_length = 0;

		while(!edges.isEmpty()){
			Edge curr = edges.poll();
			Point aSet = getSet(curr.a);
			Point bSet = getSet(curr.b);
			if(aSet == bSet)
				continue;

			total_length += curr.weight;
			bSet.parent = aSet;
		}
		return total_length;
	}



	public static Point getSet(Point p){
		if(p.parent != null){
			p.parent = getSet(p.parent);
			return p.parent;
		}
		return p;
	}
}


class Edge {
	Point a, b;
	double weight;
	public Edge(Point a, Point b) {
		this.a = a;
		this.b = b;
		this.weight = Distance(a, b); 
	}

	protected double Distance(Point a, Point b){
		return Math.hypot(a.x - b.x, a.y - b.y);
	}
}

class EdgeComp implements Comparator<Edge>{
	public int compare(Edge a, Edge b){
		if(a.weight - b.weight > 0)
			return 1;
		if(a.weight - b.weight == 0)
			return 0;
		return -1;
	}
}


class Point {
	Point parent;
	double x, y;
	public Point(int x, int y){
		parent = null;
		this.x = (double)x;
		this.y = (double)y;
	}
}

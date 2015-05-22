// Djikstra

// Given a weighted directed graph with 1≤n≤10^3 vertices and 0≤m≤10^5
// edges, and two vertices 1≤u,v≤n. Output the minimal weight of a path
// from u to v, or -1 if there is no such path. All the edge weights are positive integers not exceeding 10^3.

// Sample Input:
// 4 4
// 1 2 1
// 4 1 2
// 2 3 2
// 1 3 5
// 1 3
// Sample Output:
// 3

import java.util.*;

class Main {
  public static void main(String[] args) {
 	Scanner sc = new Scanner(System.in);
 	int n = sc.nextInt();
 	int m = sc.nextInt();

 	Node[] graph = new Node[n+1];
 	for(int i = 0; i < m; i++){
 		int node1 = sc.nextInt();
 		int node2 = sc.nextInt();
 		int weight = sc.nextInt();

 		if(graph[node1] == null)
 			graph[node1] = new Node(node1);
 		if(graph[node2] == null)
 			graph[node2] = new Node(node2);
 		graph[node1].edges.add(new DirEdge(graph[node2], weight));
 	}

 	int pathStart = sc.nextInt();
 	int pathEnd = sc.nextInt();
 	if(graph[pathStart] == null || graph[pathEnd] == null)
 		System.out.println(-1);
 	else
 		System.out.println(Djikstra(graph[pathStart], graph[pathEnd]));
  }

  public static int Djikstra(Node start, Node end){

  	PriorityQueue<Node> pq = new PriorityQueue<Node>(11, new NodeComp()); 
  	start.distance = 0;
  	pq.add(start);

  	while(!pq.isEmpty()){
  		Node curr = pq.poll();
  		//handle duplicates on the queue.
  		//duplicates exist because algorithm readds nodes when their distances are changed
  		//so that nodes are sorted correctly on the priority queue.
  		if(curr.done) 
  			continue;
  		//System.err.println("Curr node = " + curr.vertex_num);
  		if(curr.equals(end))
  			return curr.distance;

  		for(DirEdge e : curr.edges){
  			Node neighbor = e.end;
  			//System.err.println("on edge of " + curr.vertex_num + " corr. to " + neighbor.vertex_num);
  			if(neighbor.distance > curr.distance + e.weight){
  				neighbor.distance = curr.distance + e.weight;
	  			//System.err.println(neighbor.vertex_num + " now has distance " + neighbor.distance);
	  			pq.add(neighbor);
	  		}
  		}
  		curr.done = true;
  	}
  	return -1;
  }
}

class NodeComp implements Comparator<Node>{
	public int compare(Node a, Node b){
		return a.distance - b.distance;
	}	
}

class Node{
	int vertex_num;
	int distance;
	boolean done;
	LinkedList<DirEdge> edges;

	public Node(int num){
		vertex_num = num;
		distance = Integer.MAX_VALUE;
		done = false;
		edges = new LinkedList<DirEdge>();
	}

	public boolean equals(Node other){
		if(this.vertex_num == other.vertex_num)
			return true;
		return false;
	}
}

class DirEdge{
	int weight;
	Node end;

	public DirEdge(Node end, int weight){
		this.end = end;
		this.weight = weight;
	}
}
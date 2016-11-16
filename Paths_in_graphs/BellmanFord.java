// Detecting Negative Cycles

// Given a weighted directed graph with 1≤n≤10^3 vertices 
// and 0≤m≤10^4 edges. Output 1 if the graph contains a 
// cycle of negative weight and 0 otherwise. All the edge 
// weights are integers of absolute value at most 10^3.

// Sample Input:
// 4 4
// 1 2 1
// 4 1 2
// 2 3 2
// 3 1 -5
// Sample Output:
// 1

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    Node[] graph = new Node[n+1];
    LinkedList<DirEdge> edges = new LinkedList<DirEdge>();
    for(int i = 0; i < m; i++){
    	int sourceNum = sc.nextInt();
    	int endNum = sc.nextInt();
    	int weight = sc.nextInt();

    	if(graph[sourceNum] == null)
    		graph[sourceNum] = new Node(sourceNum);
    	if(graph[endNum] == null)
    		graph[endNum] = new Node(endNum);

    	edges.add(new DirEdge(graph[sourceNum], graph[endNum], weight));
    }

    Node start = null;
    for(int i = 0; i < graph.length; i++){
    	if(graph[i] != null){
    		start = graph[i];
    	}
    }

    if(start == null)
    	System.out.println(0);
    else
    	System.out.println(BellmanFord(start, graph, edges));
  }

  public static int BellmanFord(Node start, Node[] graph, LinkedList<DirEdge> edges){
  	start.distance = 0;

  	//relax all edges v - 1 times
  	boolean noUpdates = true;
  	for(int i = 1; i < graph.length - 1; i++){
  		for(DirEdge edge : edges){
  			// System.err.println("Checking edge from " + edge.source.vertex_num  + " to " + edge.end.vertex_num);
  			// System.err.println("edge.end's current distance: " + edge.end.distance);
  			// System.err.println("possible update: " + edge.source.distance + edge.weight);
  			if(edge.end.distance > edge.source.distance + edge.weight){
  				//System.err.println("Updating from " + edge.end.distance + " to " + (edge.source.distance + edge.weight));
  				edge.end.distance = edge.source.distance + edge.weight;
  				noUpdates = false;
  			}
  		}
  		//if nothing is updated in a round, then there can't be negative
  		//cycles; a negative cycle means infinite improvement. It also
  		//indicates that all shortest paths have been found. 
  		if(noUpdates){
  			//System.err.println("No updates made");
  			return 0;
  		}
  	}

  	//check for negative cycles
  	for(DirEdge edge : edges){
  		//if a vertex/node is updated, that indicates a negative
  		//cycle; return 1.
  		if(edge.end.distance > edge.source.distance + edge.weight)
  			return 1;
  	}

  	//if no edges cause a return, no empty cycles
  	return 0;
  }
}

class Node {
	int vertex_num;
	int distance;

	public Node(int num){
		vertex_num = num;
		distance = 10000;
	}
}

class DirEdge {
	int weight;
	Node source;
	Node end;

	public DirEdge(Node source, Node end, int weight){
		this.source = source;
		this.end = end;
		this.weight = weight;
	}
}
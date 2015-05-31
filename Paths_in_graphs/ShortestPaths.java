// Advanced Code Problem: Shortest Paths

// The first line of the input contains the number of 
// vertices 1≤n≤10^3, the number of edges 0≤m≤10^4, and a 
// vertex 1≤s≤n of a directed graph. The next m lines 
// define the edges of the graph. All the weights are 
// integers of absolute value at most 10^9. For all vertices 
// u from 1 to n output the following in a separate line:
//
// o   *, if there is no path from s to u;
// o   -, if there is a path from s to u, but there is no 
//        shortest path from s to u (i.e., the distance 
//        from s to u is −∞);
// o    the length of a shortest path otherwise.

// Sample Input 1:
// 6 7 1
// 1 2 10
// 2 3 5
// 1 3 100
// 3 5 7
// 5 4 10
// 4 3 -18
// 6 1 -1
// Sample Output 1:
// 0
// 10
// -
// -
// -
// *

// Sample Input 2:
// 5 4 4
// 1 2 1
// 4 1 2
// 2 3 2
// 3 1 -5
// Sample Output 2:
// -
// -
// -
// 0
// *
import java.util.*;
import java.math.BigInteger;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int s = sc.nextInt();

    Node[] graph = InitGraph(n);
    LinkedList<DirEdge> edges = new LinkedList<DirEdge>();
    for(int i = 0; i < m; i++){
    	int sourceNum = sc.nextInt();
    	int endNum = sc.nextInt();
    	BigInteger weight = sc.nextBigInteger();

      DirEdge newEdge = new DirEdge(graph[sourceNum], graph[endNum], weight);
      graph[sourceNum].edges.add(newEdge);
    	edges.add(newEdge);
    }

    Node start = graph[s];
    BellmanFord(start, graph, edges);
  }

  public static void BellmanFord(Node start, Node[] graph, LinkedList<DirEdge> edges){
    start.distance = BigInteger.ZERO;
  	//relax all edges v - 1 times
  	for(int i = 1; i < graph.length - 1; i++){
  		for(DirEdge edge : edges){
  			// System.err.println("Checking edge from " + edge.source.vertex_num  + " to " + edge.end.vertex_num);
  			// System.err.println("edge.end's current distance: " + edge.end.distance);
  			// System.err.println("possible update: " + edge.source.distance + edge.weight);
  			if(edge.end.distance.compareTo(edge.source.distance.add(edge.weight)) > 0){
  				//System.err.println("Updating from " + edge.end.distance + " to " + (edge.source.distance + edge.weight));
  				edge.end.distance = edge.source.distance.add(edge.weight);
  			}
  		}
  	}

  	//check for negative cycles
	  for(DirEdge edge : edges){
      if(edge.end.inNegativeCycle)
        continue;
		  if(edge.end.distance.compareTo(edge.source.distance.add(edge.weight)) > 0){
        DFS(edge.end.vertex_num, graph);
      }
    }
    PrintOutput(graph);
  }

  public static void DFS(int startNum, Node[] graph){
    if(graph[startNum].inNegativeCycle)
      return;

    graph[startNum].inNegativeCycle = true;
    for(DirEdge e : graph[startNum].edges){
      DFS(e.end.vertex_num, graph);
    }
  }

  public static void PrintOutput(Node[] graph){
    for(int i = 1; i < graph.length; i++){
      if(graph[i].inNegativeCycle)
        System.out.println("-");  
      else if(graph[i].distance.compareTo(Constants.THRESH) > 0)
        System.out.println("*");
      else
        System.out.println(graph[i].distance);
    }
  }



  public static Node[] InitGraph(int num_vertices){
  	Node[] toReturn = new Node[num_vertices+1];
  	for(int i = 1; i < toReturn.length; i++)
  		toReturn[i] = new Node(i);
  	return toReturn;
  }
}

class Node {
	int vertex_num;
	BigInteger distance;
  boolean inNegativeCycle;
  LinkedList<DirEdge> edges;

	public Node(int num){
		vertex_num = num;
		distance = Constants.MAX_VALUE;
    inNegativeCycle = false;
    edges = new LinkedList<DirEdge>();
	}
}

class DirEdge {
	BigInteger weight;
	Node source;
	Node end;

	public DirEdge(Node source, Node end, BigInteger weight){
		this.source = source;
		this.end = end;
		this.weight = weight;
	}
}

class Constants{
  public static final BigInteger MAX_VALUE = BigInteger.TEN.pow(20); 
  public static final BigInteger THRESH = BigInteger.TEN.pow(14);
}
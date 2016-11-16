// Breadth-First Search

// Problem Statement: Given an undirected graph with 1≤n≤10^5 
// vertices and 0≤m≤10^5 edges and two vertices 1≤u,v≤n. Output 
// the minimal number of edges in a path from u to v, or -1 
// if there is no such path.

// Sample Input:
// 4 4
// 1 2
// 4 1
// 2 3
// 3 1
// 2 4
// Sample Output:
// 2

import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	HashMap<Integer, LinkedList<Integer>> graph = 
  						new HashMap<Integer, LinkedList<Integer>>();
  	for(int i = 0; i < m; i++){
  		int node1 = sc.nextInt();
  		int node2 = sc.nextInt();
  		if(!graph.containsKey(node1))
  			graph.put(node1, new LinkedList<Integer>());
  		if(!graph.containsKey(node2))
  			graph.put(node2, new LinkedList<Integer>());

  		graph.get(node1).add(node2);
  		graph.get(node2).add(node1);
  	}

  	int[] distances = new int[n+1];
  	for(int i = 1; i < distances.length; i++)
  		distances[i] = Integer.MAX_VALUE;

  	System.out.println(BFS(sc.nextInt(), sc.nextInt(), graph, distances));
  }

  public static int BFS(int start, int end, 
  					HashMap<Integer, LinkedList<Integer>> graph,
  					int[] distances){

  	if(!graph.containsKey(start) || !graph.containsKey(end))
  		return -1;

  	LinkedList<Integer> q = new LinkedList<Integer>();
  	q.add(start);
  	distances[start] = 0;
  	while(!q.isEmpty()){
  		int curr = q.poll();
  		//System.out.println("current node is " + curr);
  		if(curr == end)
  			return distances[curr];
  		for(int neighbor : graph.get(curr)){
  			//System.out.println("current neighbor of " + curr + ": " + neighbor);
  			//System.out.println("distance of current neighbor: " + distances[neighbor]);
  			if(distances[neighbor] != Integer.MAX_VALUE)
  				continue;

  			q.add(neighbor);
  			distances[neighbor] = distances[curr] + 1;
  		}
  	}
  	return -1;
  }
}
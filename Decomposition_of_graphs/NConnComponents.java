// Number of Connected Components

// Problem Statement: Given an undirected graph 
// with 1≤n≤10^3 vertices and 0≤m≤10^3 edges, output 
// the number of connected components.

import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	boolean[] visited = new boolean[n+1];
  	HashMap<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
  	for(int i = 0; i < m; i++){
  		int start = sc.nextInt();
  		int end = sc.nextInt();
  		if(!graph.containsKey(start))
  			graph.put(start, new LinkedList<Integer>());
  		if(!graph.containsKey(end))
  			graph.put(end, new LinkedList<Integer>());

  		graph.get(start).add(end);
  		graph.get(end).add(start);
  	}

  	int num_cc = 0;
  	for(int i = 1; i < visited.length; i++){
  		if(!visited[i]){
  			num_cc++;
  			DFS(i, visited, graph);
  		}
	}
	System.out.println(num_cc);
  }

  public static void DFS(int start, boolean[] visited, 
  							HashMap<Integer, LinkedList<Integer>> graph){

  	if(!graph.containsKey(start))
  		return;
  	
  	LinkedList<Integer> q = new LinkedList<Integer>();
  	q.add(start);

  	while(!q.isEmpty()){
  		int curr = q.poll();
  		if(visited[curr] == true)
  			continue;

  		LinkedList<Integer> adj = graph.get(curr);
  		while(!adj.isEmpty())
  			q.add(adj.poll());

  		visited[curr] = true;
  	}

  	return;
  }

}
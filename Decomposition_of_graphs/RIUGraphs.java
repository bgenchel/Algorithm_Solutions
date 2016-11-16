// Reachability in Undirected Graphs

// Problem Statement: Given an undirected graph 
// with 1≤n≤103 vertices and 1≤m≤10^3 edges and 
// two vertices 1≤u,v≤n. Output 1 if u is reachable 
// from v (in other words, u and v are from the same
// connected component) and 0 otherwise. 

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
  	if(DFS(sc.nextInt(), sc.nextInt(), visited, graph))
  		System.out.println(1);
  	else
  		System.out.println(0);
  }

  public static boolean DFS(int start, int end, 
  							boolean[] visited, 
  							HashMap<Integer, LinkedList<Integer>> graph){

  	if(!graph.containsKey(start) || !graph.containsKey(end))
  		return false;

  	LinkedList<Integer> q = new LinkedList<Integer>();
  	q.add(start);

  	while(!q.isEmpty()){
  		int curr = q.poll();
  		if(curr == end)
  			return true;
  		if(visited[curr] == true)
  			continue;

  		LinkedList<Integer> adj = graph.get(curr);
  		while(!adj.isEmpty())
  			q.add(adj.poll());

  		visited[curr] = true;
  	}
  	return false;
  }

}
// Testing Acyclicity

// Problem Statement: Given a directed graph with n vertices and 
// m edges (1≤n,m≤103). Output 1 if the graph contains a cycle 
// and 0 otherwise. 

import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);

  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	boolean[] previsited = new boolean[n+1];
  	boolean[] postvisited = new boolean[n+1];
  	HashMap<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
  	for(int i = 0; i < m; i++){
  		int start = sc.nextInt();
  		int end = sc.nextInt();
  		if(!graph.containsKey(start))
  			graph.put(start, new LinkedList<Integer>());
  		if(!graph.containsKey(end))
  			graph.put(end, new LinkedList<Integer>());
  		graph.get(start).add(end);
  	}

  	for(int i = 1; i < previsited.length; i++){
  		if(!previsited[i]){
  			if(DFS(i, previsited, postvisited, graph)){
  				System.out.print(1);
  				return;
  			}
  		}
  	}
	System.out.println(0);
  }

  public static boolean DFS(int start, boolean[] previsited,
  							boolean[] postvisited, 
  							HashMap<Integer, LinkedList<Integer>> graph){

  	if(!graph.containsKey(start))
  		return false;
  	
  	if(previsited[start] && !postvisited[start])
		return true;

	previsited[start] = true;

	LinkedList<Integer> adj = graph.get(start);
  	while(!adj.isEmpty()){
  		int neighbor = adj.poll();

  		if(DFS(neighbor, previsited, postvisited, graph))
  			return true;

  	}

  	postvisited[start] = true;
  	return false;
  }

}
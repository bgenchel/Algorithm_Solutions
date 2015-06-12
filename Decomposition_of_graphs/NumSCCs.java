// Number of Strongly Connected Components

// Problem Statement: Given a directed graph with 1≤n≤10^5 
// vertices and 0≤m≤10^5 edges, output the number of strongly 
// connected components in this graph.

// Sample Input:
// 4 4
// 1 2
// 4 1
// 2 3
// 3 1
// Sample Output:
// 2

//Note: This program implements Kosaraju's algorithm. 

import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);

  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	HashMap<Integer, LinkedList<Integer>> graph = GraphFactory(n);
  	HashMap<Integer, LinkedList<Integer>> inv_graph = GraphFactory(n);
  	for(int i = 0; i < m; i++){
  		int start = sc.nextInt();
  		int end = sc.nextInt();

  		graph.get(start).add(end);
  		inv_graph.get(end).add(start);
  	}

  	boolean[] visited = new boolean[n+1];
  	Stack<Integer> stack = new Stack<Integer>();
  	for(int i = 1; i <= n; i++){
  		if(!visited[i]){
  			DFS(i, visited, stack, graph);
  		}
  	}

  	int scc_count = 0;
  	visited = new boolean[n+1];
  	Stack<Integer> dummy = new Stack<Integer>();
  	while(!stack.isEmpty()){
  		int curr = stack.pop();
  		if(visited[curr])
  			continue;

  		DFS(curr, visited, dummy, inv_graph);
  		scc_count++;
  	}
  	System.out.println(scc_count);
  }

  public static HashMap<Integer, LinkedList<Integer>> GraphFactory(int num_nodes){
  	HashMap<Integer, LinkedList<Integer>> ret = new HashMap<Integer, LinkedList<Integer>>();

  	for(int i = 1; i <= num_nodes; i++)
  		ret.put(i, new LinkedList<Integer>());

  	return ret;
  }

  public static void DFS(int start, boolean[] visited,
  							Stack<Integer> stack, 
  							HashMap<Integer, LinkedList<Integer>> graph){

  	if(!graph.containsKey(start) || visited[start])
  		return;

	   visited[start] = true;

  	for(int neighbor : graph.get(start))
  		DFS(neighbor, visited, stack, graph);

  	stack.push(start);
  	return;
  }

}
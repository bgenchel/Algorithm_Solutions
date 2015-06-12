// Topological Sorting

// Problem Statement: Given a DAG with 1≤n≤10^5 vertices 
// and 0≤m≤10^5 edges. Output a topological ordering of its 
// vertices.

// Sample Input:
// 4 3
// 1 2
// 4 1
// 3 1
// Sample Output:
// 4 3 1 2

import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);

  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	int[] indegrees = new int[n+1];
  	boolean[] visited = new boolean[n+1];
  	HashMap<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();
  	for(int i = 0; i < m; i++){
  		int start = sc.nextInt();
  		int end = sc.nextInt();
  		if(!graph.containsKey(start)){
  			//System.out.println("adding " + start + " to graph.");
  			graph.put(start, new LinkedList<Integer>());
  		}
  		if(!graph.containsKey(end)){
  			//System.out.println("adding " + end + " to graph.");
  			graph.put(end, new LinkedList<Integer>());
  		}
  		//System.out.println("adding " + end + " to " + start + " list ");
  		graph.get(start).add(end);
  	}

  	Stack<Integer> sources = new Stack<Integer>();
  	for(int i = 1; i < visited.length; i++){
  		if(!visited[i])
  			CountDegrees(i, visited, indegrees, graph);
  	}
  	for(int i = 1; i < indegrees.length; i++){
  		if(indegrees[i] == 0){
  			//System.out.println("adding " + i + " to sources");
  			sources.push(i);
  		}
  	}
  	while(!sources.isEmpty()){
    		int curr = sources.pop();
    		//System.out.println("curr = " + curr);
    		System.out.print(curr + " ");
    		//printLL(graph.get(curr));
    		for(int neighbor : graph.get(curr)){
    			//System.out.println("neighbor = " + neighbor);
    			indegrees[neighbor]--;
    			if(indegrees[neighbor] == 0){
    				//System.out.println("adding " + neighbor + " to sources");
    				sources.push(neighbor);
    			}
    		}
  	}
 }

  public static void printLL(LinkedList<Integer> list){
  	//System.out.println("printing neighbors: ");
  	for(int i : list)
  		System.out.println(i);
  }

  public static void CountDegrees(int start, boolean[] visited, 
  							int[] indegrees, 
  							HashMap<Integer, LinkedList<Integer>> graph){
  	//System.out.println("CD is visiting " + start);
  	if(!graph.containsKey(start)){
  		graph.put(start, new LinkedList<Integer>());
  		return;
  	}

	for(int neighbor : graph.get(start)){
		//System.out.println("incrementing degrees for " + neighbor);
  		indegrees[neighbor]++;
  	}

  	visited[start] = true;

  	return;
  }

}
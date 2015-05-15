// Advanced: Recoloring Vertices

// Problem Statement: Given an undirected graph together with
// a 3-coloring of its vertices. Your goal is to recolor each 
// of its vertices so that the resulting 3-coloring is proper,
// i.e., the endpoints of each edge have different colors.

// The first line of the input contains the number of vertices 
// 1≤n≤1000 and the number of edges 0≤m≤20000. The next lines 
// contains a string of length n over the alphabet {R,G,B} — 
// the initial colors of the vertices. 
// The next m lines define the edges of the graph. Output a 
// proper 3-coloring where each vertex is assigned a color 
// different from its initial coloring. If there is no such 
// coloring output "Impossible". 

// Sample Input 1:
// 4 5
// RRRG
// 1 3
// 1 4
// 3 4
// 2 4
// 2 3
// Sample Output 1:
// GGBR

// Sample Input 2:
// 4 5
// RGRR
// 1 3
// 1 4
// 3 4
// 2 4
// 2 3
// Sample Output 2:
// Impossible

import java.util.*;

enum Color {
	RED, GREEN, BLUE
}

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);

  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	Color[] colors = new Color[n+1];
    String init_colors = sc.next();
  	for(int i = 1; i <= init_colors.length(); i++){
  		switch(init_colors.charAt(i-1)){
  			case 'R':
  				colors[i] = Color.RED;
  				break;
  			case 'G':
  				colors[i] = Color.GREEN;
  				break;
  			case 'B':
  				colors[i] = Color.BLUE;
  				break;
  		}
    }

  	HashMap<Integer, LinkedList<Integer>> graph = GraphFactory(n);
  	for(int i = 0; i < m; i++){
  		int start = sc.nextInt();
  		int end = sc.nextInt();

      if(!graph.get(start).contains(end))
  		  graph.get(start).add(end);
      if(!graph.get(end).contains(start))
        graph.get(end).add(start);
  	}

  	boolean[] previsited = new boolean[n+1];
    boolean[] postvisited = new boolean[n+1];
  	for(int i = 1; i <= n; i++){
  		if(!previsited[i]){
  			if(!DFS(i, previsited, postvisited, colors, graph)){
          System.out.println("Impossible");
          return;
        }
  		}
  	}

    for(int i = 1; i < colors.length; i++){
      switch(colors[i]){
        case RED:
          System.out.print('R');
          break;
        case GREEN:
          System.out.print('G');
          break;
        case BLUE:
          System.out.print('B');
          break;
      }
    }
    return;
  }


  public static boolean DFS(int start, boolean[] previsited,
                boolean[] postvisited,
                Color[] colors, 
  							HashMap<Integer, LinkedList<Integer>> graph){

  	if(!graph.containsKey(start) || previsited[start])
  		return true;

    previsited[start] = true;
    LinkedList<Color> possible_colors = GenerateColorList();
  	for(int neighbor : graph.get(start)){
      if(!DFS(neighbor, previsited, postvisited, colors, graph))
        return false;
    }

    possible_colors.remove(colors[start]);
    for(int neighbor : graph.get(start)){
      if(previsited[neighbor] && postvisited[neighbor])
        possible_colors.remove(colors[neighbor]);
    }

    if(possible_colors.isEmpty())
      return false;
    
    colors[start] = possible_colors.peek();
    postvisited[start] = true;
 	  return true;
  }

  public static LinkedList<Color> GenerateColorList(){
    LinkedList<Color> ret = new LinkedList<Color>();
    ret.add(Color.RED);
    ret.add(Color.GREEN);
    ret.add(Color.BLUE);
    return ret;
  }

  public static HashMap<Integer, LinkedList<Integer>> GraphFactory(int num_vertices){
  	HashMap<Integer, LinkedList<Integer>> ret = new HashMap<Integer, LinkedList<Integer>>();

  	for(int i = 1; i <= num_vertices; i++)
  		ret.put(i, new LinkedList<Integer>());

  	return ret;
  }

}
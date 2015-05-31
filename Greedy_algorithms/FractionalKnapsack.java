// Fractional Knapsack

// The first line of the input contains the 
// number 1≤n≤10^3 of items and the weight 
// 0≤W≤2*10^6 of a knapsack. The next n lines 
// define the cost 0≤ci≤2*10^6 and the weight 
// 0≤wi≤2*10^6 of i-th item (n, W, ci's, wi's 
// are integers). Output the maximal possible 
// cost of the knapsach with at least three digits 
// of precision.

// Sample Input:
// 3 50
// 60 20
// 100 50
// 120 30
// Sample Output:
// 180.000

import java.util.*;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int weight_limit = sc.nextInt();

		LinkedList<Item> items = new LinkedList<Item>();
		for(int i = 0; i < n; i++)
			items.add(new Item(sc.nextInt(), sc.nextInt()));
		Collections.sort(items, new ItemComp());
		
		int current_weight = 0;
		double current_cost = 0;
		System.out.println("\n");
		while(current_weight < weight_limit && !items.isEmpty()){
			int remaining_weight = weight_limit - current_weight;
			Item curr = items.poll();

			if(curr.weight <= remaining_weight){
				current_weight += curr.weight;
				current_cost += curr.cost;
			} 

			if(curr.weight > remaining_weight){
				current_cost += remaining_weight*curr.costWeightRatio;
				current_weight += remaining_weight;
			}
		}

		System.out.printf("%.3f", current_cost);		
	}
}



class Item {
	int cost, weight;
	double costWeightRatio;

	public Item(int cost, int weight){
		this.cost = cost;
		this.weight = weight;
		costWeightRatio = ((double)cost)/weight;
	}
}



class ItemComp implements Comparator<Item> {
	public int compare(Item a, Item b){
		double diff = a.costWeightRatio - b.costWeightRatio;
		if(diff > 0)
			return -1;
		else if(diff == 0)
			return 0;
		else 
			return 1;
	}
}
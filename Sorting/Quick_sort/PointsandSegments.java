import java.util.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();
  	int m = sc.nextInt();

  	ArrayList<Integer> starts = new ArrayList<Integer>();
  	ArrayList<Integer> ends = new ArrayList<Integer>();
  	ArrayList<Integer> points = new ArrayList<Integer>();

  	for(int i = 0; i < n; i++){
  		starts.add(sc.nextInt());
  		ends.add(sc.nextInt());
  	}
  	starts.add(Integer.MAX_VALUE);
  	ends.add(Integer.MAX_VALUE);

  	for(int i = 0; i < m; i++)
  		points.add(sc.nextInt());

  	ArrayList<Integer> us_points = new ArrayList<Integer>(points);
  	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

  	points.add(Integer.MAX_VALUE);

  	Collections.sort(starts);
  	Collections.sort(ends);
  	Collections.sort(points);

  	int count = 0, i = 0, j = 0, k = 0;
  	while(j < points.size() - 1){
  		if(starts.get(i) <= points.get(j) 
  				&& starts.get(i) <= ends.get(k)){
  			count++;
  			i++;
  			continue;
  		}

  		if(points.get(j) < starts.get(i) 
  				&& points.get(j) <= ends.get(k)){
  			map.put(points.get(j), count);
  			j++;
  			continue;
  		} 

  		if(ends.get(k) < starts.get(i) 
  				&& ends.get(k) < points.get(j)){
  			count--;
  			k++;
  		}
  	}

  	for(int index = 0; index < us_points.size(); index++)
  		System.out.print(map.get(us_points.get(index)) + " ");

  	return;
  }
}
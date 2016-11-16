import java.util.*;


class Main {

  static boolean noSuchOrder = false; 

  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	int n = sc.nextInt();

  	Switch[] switches = new Switch[n];
  	for(int i = 0; i < n; i++)
      switches[i] = new Switch(i, sc.nextInt());

    for(int i = 0; i < n; i++)
      switches[i].setOnTime(sc.nextInt());
  
    Switch[] sorted = SortSwitches(0, n-1, switches);
    if(noSuchOrder){
      System.out.println(-1);
      return;
    }

    int total_up = 0;
    for(int i = sorted.length - 1; i >= 0; i--){
      sorted[i].setSortedOrder(i + 1);
      if(sorted[i].on_time <= total_up){
        System.out.println(-1);
        return;
      }
      total_up += sorted[i].up_time;
    }

    for(int i = 0; i < switches.length; i++)
      System.out.print(switches[i].sorted_order + " ");

    return;
  }


  public static Switch[] SortSwitches(int l, int r, Switch[] switches){
    if(l >= r){
      Switch[] s = {switches[l]};
      return s;
    }

    int m = (r + l)/2;
    return merge(SortSwitches(l, m, switches), SortSwitches(m+1, r, switches));
  }

  public static Switch[] merge(Switch[] left, Switch[] right){
    Switch[] toReturn = new Switch[left.length + right.length];
    int i = 0, j = 0, k = 0;
    while(i < left.length && j < right.length){
      if(compareSwitches(left[i], right[j])){
        toReturn[k] = left[i];
        i++;
      } else {
        toReturn[k] = right[j];
        j++;
      }
      k++;
    }

    while(i < left.length){
      toReturn[k] = left[i];
      i++;
      k++;
    }

    while(j < right.length){
      toReturn[k] = right[j];
      j++;
      k++;
    }

    return toReturn;
  }

  public static boolean compareSwitches(Switch one, Switch two){
    boolean flag1 = false, flag2 = false, flag3 = false;
    if(one.on_time > two.up_time)
      flag1 = true;
  
    if(two.on_time > one.up_time)
      flag2 = true;
    
    if(flag1 && flag2){    
      if(one.up_time + one.on_time > two.on_time + two.up_time)
        return true;
      else 
        return false;
    }

    if(!flag1 && !flag2)
      noSuchOrder = true;

    return flag1;
  }
}


class Switch{
    public int print_order, sorted_order;
    public int up_time, on_time;

    public Switch(int print_order, int up_time){
      this.print_order = print_order;
      this.up_time = up_time;
    }

    public void setOnTime(int time){
      this.on_time = time;
    }
    
    public void setSortedOrder(int order){
      this.sorted_order = order;
    }

}
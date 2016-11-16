import java.util.Scanner;
import java.util.ArrayList;

class Main {

	public static int[] heap;
	public static int last;

  	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();

    	heap = new int[n+1];
    	heap[0] = -1;
    	last = 0;

    	for(int i = 1; i <= n; i++){
        	heap[i] = sc.nextInt();
			last++;
		}

        for(int i = n; i > 0; i--)
        	siftUp(i);

        //System.out.println("\n");
        while(last > 0)
        	System.out.print(popMin() + " ");
    }

    public static int popMin(){
    	//System.out.println("entered popMin");
    	int retVal = heap[1];
    	//System.out.println("Min value is " + retVal);

    	heap[1] = heap[last];
    	heap[last] = Integer.MAX_VALUE;
    	last--;

    	siftDown(1);
    	return retVal;
    }

    public static void siftUp(int index){
    	//System.out.println("in siftUp");
    	//System.out.println("index = " + index);
    	if(index <= 1)
    		return;

    	int par = index/2;
    	//System.out.println("parent index = " + par);
    	if(heap[index] < heap[par]){
    		int temp = heap[par];
    		heap[par] = heap[index];
    		heap[index] = temp;

    		siftDown(index);
    	}
    	return;
    }

    public static void siftDown(int index){
    	// System.out.println("in siftDown");
    	// System.out.println("index = " + index);
    	if(index >= heap.length)
    		return;

    	int l = index*2, r = index*2 + 1;
    	int mindex = index;
    	if(r < heap.length){
			if(heap[l] <= heap[r])
				mindex = l;
			else
				mindex = r;
	    } else if(l < heap.length)
	    	mindex = l;

	    if(heap[index] > heap[mindex]){
    		int temp = heap[index];
    		heap[index] = heap[mindex];
    		heap[mindex] = temp;

    		siftDown(mindex);
	    }

    	return;
    }


}
import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static int[] array;
	public static BigInteger n_inv = BigInteger.ZERO;

  	public static void main(String[] args) {
  		Scanner sc = new Scanner(System.in);
  		int n = sc.nextInt();

      if(n < 1){
        System.out.println(0);
        return;
      }

  		array = new int[n];
  		for(int i = 0; i < n; i++)
  			array[i] = sc.nextInt();

  		int[] sol = invSort(0, n-1);
  		//System.out.println("\nSorted Array:");
  		//for(int i = 0; i < sol.length; i++)
  		//	System.out.println(sol[i]);
  		//System.out.println("\n");
  		System.out.println(n_inv.toString());
  	}

  	public static int[] invSort(int l, int r){
  		if(l >= r){
  			int[] s = {array[l]};
  			return s;
  		}

  		int m = (l + r)/2;
  		return merge(invSort(l, m), invSort(m+1, r));
  	}

  	public static int[] merge(int[] left, int[] right){
  		// System.out.println("\nmerging ...");
  		// System.out.println("left: ");
  		// for(int i = 0; i < left.length; i++)
  		// 	System.out.println(left[i]);
  		// System.out.println("\n");
  		// System.out.println("right: ");
  		// for(int i = 0; i < right.length; i++)
  		// 	System.out.println(right[i]);

  		int[] result = new int[left.length + right.length];
  		int i = 0, j = 0, k = 0;
  		while(k < result.length){
  			if(i < left.length && j < right.length){
  				if(left[i] <= right[j]){
  					result[k] = left[i];
  					i++;
  				} else {
  					result[k] = right[j];
  					j++;

  					n_inv = n_inv.add(new BigInteger(Integer.toString(left.length - i)));
  				}
  				k++;
  			} else if(i < left.length){
  				result[k] = left[i];
  				k++;
  				i++;
  				//while(i < left.length){
  					//result[k] = left[i];
  					//numinv += right.length;
  					//i++;
  					//k++;
  				//}
  			} else if(j < right.length){
          result[k] = right[j];
          j++;
          k++;
  				//while(j < right.length){
  					//result[k] = right[j];
  					//j++;
  					//k++;
  				//}
  			}
  		}
  		// System.out.println("\nnum inversions: " + numinv);
  		return result;
  	}
}
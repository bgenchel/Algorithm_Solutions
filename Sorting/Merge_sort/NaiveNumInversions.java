import java.util.Scanner;
import java.math.BigInteger;

class NaiveNumInversions {
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

      for(int i = 0; i < n; i++){
        for(int j = i+1; j < n; j++){
          //System.out.println("entered here");
          //System.out.println("array[" + i + "] = " + array[i]);
          //System.out.println("array[" + j + "] = " + array[j]);
          if(array[i] > array[j])
            n_inv = n_inv.add(BigInteger.ONE);
        }
      }
  		System.out.println(n_inv.toString());
  	}
}
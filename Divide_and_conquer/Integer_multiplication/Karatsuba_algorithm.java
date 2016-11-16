import java.math.BigInteger;
import java.lang.Math;
import java.util.Scanner;

class Main {
  	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	BigInteger x = sc.nextBigInteger();
    	BigInteger y = sc.nextBigInteger();
  
   		System.out.print(Karatsuba(x, y));
  	}
    
	public static BigInteger Karatsuba(BigInteger x, BigInteger y){
		//System.out.println("NEW STACK\n");
		String x_string = x.toString();
		String y_string = y.toString();
		int diff = x_string.length() - y_string.length();
		//System.out.println("diff = " + diff);
		if(diff > 0){
			for(int i = 0; i < diff; i++)
				y_string = "0" + y_string;
		} else if (diff < 0){
			for(int i = 0; i < Math.abs(diff); i++)
				x_string = "0" + x_string;
		}

		// if(x_string.length() == y_string.length())
		// 	System.out.println("lengths equal");
		// else 
		// 	System.out.println("LENGTHS NOT EQUAL");

		// System.out.println("y_string = " + y_string);
		// System.out.println("x_string = " + x_string);

		int n = x_string.length();

		if(n < 6)
			return x.multiply(y);

		int divpt = n/2;
		if(n%2 != 0)
			divpt++;

		BigInteger xL 
			= new BigInteger(x_string.substring(0, divpt));
		//System.out.println("xL = " + xL);
		BigInteger xR 
			= new BigInteger(x_string.substring(divpt));  
		//System.out.println("xR = " + xR);
		BigInteger yL
			= new BigInteger(y_string.substring(0, divpt));
		//System.out.println("yL = " + yL);
		BigInteger yR
			= new BigInteger(y_string.substring(divpt));
		//System.out.println("yR = " + yR);

		BigInteger p1 = Karatsuba(xL, yL);
		BigInteger p2 = Karatsuba(xR, yR);
		BigInteger p3 = Karatsuba(xL.add(xR), yL.add(yR));

		BigInteger term1 = p1.multiply((BigInteger.TEN).pow(2*(n/2)));
		BigInteger term2 = p3.subtract(p1).subtract(p2);
		term2 = term2.multiply((BigInteger.TEN).pow(n/2));

		return term1.add(term2).add(p2);
	}
}


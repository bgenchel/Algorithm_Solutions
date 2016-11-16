import java.math.BigInteger;
import java.util.Scanner;

public class TestFunctions{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		int n = x.length();
		int divpt = n/2;
		if(n%2 != 0)
			divpt++;
		String xL = x.substring(0, divpt);
		String xR = x.substring(divpt);
		System.out.println("input: " + x);
		System.out.println("left side = " + xL);
		System.out.println("right side = " + xR);
	}

}
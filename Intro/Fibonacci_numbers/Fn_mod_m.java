// Problem Statement:

// Given 1≤n≤10^18 and 2≤m≤10^5, output Fnmodm. 

// Sample Input:
// 281621358815590 30524
// Sample Output:
// 11963

// Memory Limit: 256 MB
// Time Limit: 5 seconds

import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
        
class Main {
    public static BigInteger mod;
    public static void main(String[] args) {
        System.out.print("enter n and m: ");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        mod = new BigInteger(String.valueOf(m));
        System.out.println("running the program");
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        if(n < 2){
          System.out.print(n);
          return;
        }
        System.out.println(fibmod(n));
        return;
    }
  
    public static BigInteger fibmod(long n){
        //System.out.println("Entered fib()");
        BigInteger[][] T = new BigInteger[][]{
            {BigInteger.ZERO, BigInteger.ONE},
            {BigInteger.ONE, BigInteger.ONE}
        };
        BigInteger[][] start = new BigInteger[][]{
            {BigInteger.ZERO}, 
            {BigInteger.ONE}
        };
        //print_mat(start);
        BigInteger[][] Tf = mat_pow(T, n - 1);
        BigInteger[][] end = mat_mult(Tf, start);
        return end[1][0];
    }
    
    public static BigInteger[][] mat_mult(BigInteger[][] one, BigInteger[][] two){
        //System.out.println("Entered mat_mult()");
        if(one[0].length != two.length)
            return null;
        //System.out.println("entered mat_mult");
        BigInteger[][] ret = new BigInteger[one.length][two[0].length];
        for(int i = 0; i < one.length; i++){
            for(int j = 0; j < two[0].length; j++){
                for(int k = 0; k < one[0].length; k++){
                    if(ret[i][j] == null)
                        ret[i][j] = BigInteger.ZERO;
                    ret[i][j] = ret[i][j].add(one[i][k].multiply(two[k][j])).mod(mod);
                }
            }
        }
        return ret;
    }
            
    public static BigInteger[][] mat_pow(BigInteger[][] T, long p){
        //System.out.println("Entered mat_pow");
        //System.out.println("p = " + p);
        //print_mat(T);
        if(p == 1)
            return T;
        if(p%2 == 0){
            BigInteger[][] A = mat_pow(T, p/2);
            return mat_mult(A, A);
        }
        
        return mat_mult(T, mat_pow(T, p - 1));
    }

    public static void print_mat(BigInteger[][] T){
        for(int i = 0; i < T.length; i++){
            for(int j = 0; j < T[0].length; j++){
                System.out.print(T[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println(" ");
    }
}

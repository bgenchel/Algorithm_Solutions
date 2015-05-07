// Problem Statement:

// The first line of the input contains an integer 1≤n≤10^5 
// and an array A[1…n] containing n pairwise different positive 
// integers from 1 to 109 in increasing order: A[1]<A[2]<…<A[n]. 
// The next line contains an integer 1≤k≤10^5 and k positive 
// integers b1,…,bk. For all i from 1 to k, output an index 1≤j≤n
// such that A[j]=bi or −1 is there is no such index.

// Sample Input:
// 5 1 5 8 12 13
// 5 8 1 23 1 11
// Sample Output:
// 3 1 -1 1 -1

// Memory Limit: 256 MB
// Time Limit: 5 seconds

import java.util.Scanner;

class BinarySearch{
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] toSearch = new int[n];
      for(int i = 0; i < n; i++)
          toSearch[i] = sc.nextInt();
      int k = sc.nextInt();
      for(int i = 0; i < k; i++){
          System.out.print(bsearch(toSearch, sc.nextInt()));
          System.out.print(" ");
      }
  }

  public static int bsearch(int[] toSearch, int toFind){
      int left = 0, right = toSearch.length-1;
      int mid = (right + left)/2;
      while(left <= right){
          if(toSearch[mid] == toFind)
              return mid + 1;
          if(toFind > toSearch[mid])
              left = mid + 1;
          else 
              right = mid - 1;
          mid = (right + left)/2;
      }
      return -1;
  }   
}
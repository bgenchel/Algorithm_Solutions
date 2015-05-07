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
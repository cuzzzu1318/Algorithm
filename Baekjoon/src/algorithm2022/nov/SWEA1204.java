package algorithm2022.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1204 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      LinkedList<Integer> ansArr = new LinkedList<>();
      for(int i = 0;i<T;i++) {
    	  int[] arr = new int[101];
    	  Arrays.fill(arr, 0);
          int cnt = 0;
          int max = 0;
    	  int num = Integer.parseInt(br.readLine());
    	  String[] str = br.readLine().split(" ");
    	  for(int j = 0;j<str.length;j++) {
    		  arr[Integer.parseInt(str[j])]++;
    	  }
    	  for(int j = 0;j<101;j++) {
    		  if(arr[j]>=cnt) {
    			  if(j>max) {
    				  max=j;
    				  cnt=arr[j];
    			  }
    		  }
    	  }
    	  ansArr.add(max);
      }
      int i = 1;
      for(int item : ansArr) {
    	  System.out.println("#"+i+++" "+item);
      }
   }
}
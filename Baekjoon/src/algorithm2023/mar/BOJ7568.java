package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ7568 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      ArrayList<int[]> arr = new ArrayList<>();
      int[] ans = new int[N];
      for(int i = 0;i<N;i++) {
    	  int[] temp = new int[2];
    	  String[] s = br.readLine().split(" ");
    	  temp[0] = Integer.parseInt(s[0]);
    	  temp[1] = Integer.parseInt(s[1]);
    	  arr.add(temp);
      }
      
      for(int i = 0;i<N;i++) {
    	  ans[i]=1;
    	  for(int j = 0;j<N;j++) {
    		  if(arr.get(i)[0]<arr.get(j)[0]&&arr.get(i)[1]<arr.get(j)[1]) {
    			 ans[i]++; 
    		  }
    	  }
      }
      
      for(int i : ans) {
    	  System.out.print(i+" ");
      }
      
      
   }
}
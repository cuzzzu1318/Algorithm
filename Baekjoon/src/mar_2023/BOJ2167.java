package mar_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2167 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int M = Integer.parseInt(s[1]);
      int[][] arr = new int[N][M];
      for(int i  =0;i<N;i++) {
    	  s = br.readLine().split(" ");
    	  for(int j = 0;j<M;j++) {
    		  arr[i][j] = Integer.parseInt(s[j]);
    	  }
      }
      
      int K = Integer.parseInt(br.readLine());
      for(int num = 0;num<K;num++) {
    	  s = br.readLine().split(" ");
    	  int i = Integer.parseInt(s[0])-1;
    	  int j = Integer.parseInt(s[1])-1;
    	  int x = Integer.parseInt(s[2])-1;
    	  int y = Integer.parseInt(s[3])-1;
    	  int sum = 0;
    	 
    	  for(;i<=x;i++) {
    		  for(int j2 = j;j2<=y;j2++) { 
    			  sum+=arr[i][j2];
    		  }
    	  }
    	  System.out.println(sum);
    	  
      }
      
   }
}
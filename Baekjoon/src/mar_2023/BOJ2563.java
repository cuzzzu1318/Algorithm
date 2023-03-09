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

public class BOJ2563 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      ArrayList<int[]> arr = new ArrayList<>();
      
      int[][] ans = new int[100][100];
      
      for(int i = 0;i<n;i++) {
    	  int[] temp = new int[2];
    	  String[] s = br.readLine().split(" ");
    	  temp[0] = Integer.parseInt(s[0]);
    	  
    	  temp[1] = Integer.parseInt(s[1]);
    	  for(int x = temp[0];x<temp[0]+10;x++) {
    		  for(int y = temp[1];y<temp[1]+10;y++) {
        		  ans[x][y]=1;
        	  }
    	  }
    	  arr.add(temp);
      }
      int cnt = 0;
      for(int i = 0;i<100;i++) {
    	  for(int j = 0;j<100;j++) {
    		  if(ans[i][j]==1) {
    			  cnt++;
    		  }
    	  }
      }
      System.out.println(cnt);
      
      
   }
}
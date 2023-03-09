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

public class BOJ1475 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split("");
      
      int[] num = new int[9];
      for(int i = 0;i<9;i++) {
    	  num[i] = 0;
      }
      for(String c : s) {
    	  int n = Integer.parseInt(c);
    	  if(n==9) {
    		  num[6]++;
    		  continue;
    	  }
    	  num[n]++;
    	  
      }
      num[6] = (int)Math.round((float)num[6]/2);
      int max = 1;
      for(int i = 0;i<9;i++) {
    	  if(max<num[i]) {
    		  max = num[i];
    	  }
      }
      System.out.println(max);
   }
}
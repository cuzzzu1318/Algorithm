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

public class BOJ11866 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s[] = br.readLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int K = Integer.parseInt(s[1]);
      
      ArrayList<Integer> arr = new ArrayList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      for(int i =1;i<=N;i++) {
    	  arr.add(i);
      }
      int index = 0;
      int cnt = 1;
      while(!arr.isEmpty()) {
    	  if(cnt==K) {
    		  ans.add(arr.remove(index));
    		  cnt=0;
    		  index--;
    	  }
    	  cnt++;
    	  index++;
    	  if(index>=arr.size()) {
    		  index = 0;
    	  }
      }
      System.out.print("<");
      for(int i =0;i<ans.size();i++) {
    	  if(i<ans.size()-1) {
    		  System.out.print(ans.get(i)+", ");
    	  }else {
    		  System.out.print(ans.get(i));
    	  }
      }
      System.out.print(">");

   }
}
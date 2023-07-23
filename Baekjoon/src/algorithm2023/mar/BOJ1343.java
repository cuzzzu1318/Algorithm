package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 16:10~16:27 ( 27min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1343 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String[] board = br.readLine().split("");
      int cnt = 0;
      boolean isAble = true;
      String ans = "";
      for(String s : board) {
    	  if(s.equals("X")) {
    		  cnt++;
    	  }else {
    		  
    		//  bw.write(cnt+"\n");
    		  if(cnt%2==0) {
    			  for(int i = 0;i<cnt/4;i++) {
    				  ans+="AAAA";
    			  }
    			  cnt%=4;
    			  if(cnt==2) {
    				  ans+="BB";
    			  }
    			  ans+=".";
    			  cnt=0;
    		  }else {
    			  ans="-1";
    			  break;
    		  }
    		  
    	  }
      }
      
      if(cnt%2==0) {
    			  for(int i = 0;i<cnt/4;i++) {
    				  ans+="AAAA";
    			  }
    			  cnt%=4;
    			  if(cnt==2) {
    				  ans+="BB";
    			  }
    		  }else {
    			  ans="-1";
    		  }
      bw.write(ans);
      bw.flush();
      bw.close();
      
      
   }
}
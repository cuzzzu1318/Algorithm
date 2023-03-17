package mar_2023;


/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S4_BOJ1205_0317 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String[] s = br.readLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int score = Integer.parseInt(s[1]);
      int P = Integer.parseInt(s[2]);
      ArrayList<Integer> arr = new ArrayList<>();
		if (N > 0) {
			s = br.readLine().split(" ");
    	  
      }
      for(int i  =0;i<N;i++) {
    	  arr.add(Integer.parseInt(s[i]));
      }
      for(int i = N-1;i>=0;i--) {
    	  if(arr.get(i)==score) {
    		  arr.add(i, score);
    		  if(i+2>P) {
    			  bw.write("-1");
    		  }else {
    			  int index = arr.indexOf(score);
    			  bw.write(Integer.toString(index+1));
    		  }
    		  break;
    	  }else if(arr.get(i)>score) {
    		  arr.add(i, score);
    		  if(i+2>P) {
    			  bw.write("-1");
    		  }else {
    			  bw.write(Integer.toString(i+2));
    		  }
    		  break;
    	  }
      }
      if(!arr.contains(score)) {
    	  bw.write("1");
      }
     //System.out.println(arr);
      bw.flush();
      bw.close();
   }
}
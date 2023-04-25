package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S4_BOJ10866_0425 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      int N = Integer.parseInt(br.readLine());
      ArrayList<Integer> q = new ArrayList<>();
      for(int i = 0;i<N;i++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	  String func = st.nextToken();
    	  int num = 0;
    	  if(st.hasMoreTokens()) {
    		  num = Integer.parseInt(st.nextToken());
    	  }
    	  switch(func) {
    	  case "push_front":
    		  q.add(0, num);
    		  break;
    	  case "push_back":
    		  q.add(num);
    		  break;
    	  case "pop_front":
    		  if(q.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(q.remove(0))+"\n");
    		  }
    		  break;
    	  case "pop_back":
    		  if(q.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(q.remove(q.size()-1))+"\n");
    		  }
    		  break;
    	  case "size": 
    		  bw.write(Integer.toString(q.size())+"\n");
    		  break;
    	  case "empty":
    		  if(q.isEmpty()) {
    			  bw.write("1\n");
    		  }else {
    			  bw.write("0\n");
    		  }
    		  break;
    	  case "front": 
    		  if(q.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(q.get(0))+"\n");
    		  }
    		  break;
    	  case "back":
    		  if(q.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(q.get(q.size()-1))+"\n");
    		  }
    		  break;
    	  }
      }
      bw.flush();
      bw.close();
   }
   
   
}
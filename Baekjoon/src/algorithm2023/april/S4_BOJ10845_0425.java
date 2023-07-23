package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_BOJ10845_0425 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      
      Stack<Integer> stack = new Stack<>();
      int N = Integer.parseInt(br.readLine());
      for(int i = 0;i<N;i++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	  String func = st.nextToken();
    	  int num = 0;
    	  if(st.hasMoreTokens()) {
    		  num = Integer.parseInt(st.nextToken());
    	  }
    	  switch(func) {
    	  case "push": 
    		  stack.push(num);
    		  break;
    	  case "pop":
    		  if(stack.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(stack.pop())+"\n");
    		  }
    		  break;
    	  case "size":
    		  bw.write(Integer.toString(stack.size())+"\n");
    		  break;
    	  case "empty": 
    		  if(stack.isEmpty()) {
    			  bw.write("1\n");
    		  }else {
    			  bw.write("0\n");
    		  }
    		  break;
    	  case "top":
    		  if(stack.isEmpty()) {
    			  bw.write("-1\n");
    		  }else {
    			  bw.write(Integer.toString(stack.peek())+"\n");
    		  }
    		  break;
    	  }
      }
      bw.flush();
      bw.close();
   }
}
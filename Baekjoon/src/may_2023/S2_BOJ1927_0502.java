package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S2_BOJ1927_0502 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws NumberFormatException, IOException {
	   int N = Integer.parseInt(br.readLine());
	   PriorityQueue<Integer> q = new PriorityQueue<>();
	   for(int i= 0;i<N;i++) {
		   int x = Integer.parseInt(br.readLine());
		   switch(x) {
		   case 0:
			   print(q);
			   break;
		   default:
			   q.offer(x);
		   }
	   }
	   System.out.println(sb);
   }
   
   static void print(PriorityQueue<Integer> q) {
	   if(q.isEmpty()) {
		   sb.append(0+"\n");
	   }else {
		   sb.append(q.poll()+"\n");
	   }
   }
}
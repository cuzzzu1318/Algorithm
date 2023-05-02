package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_BOJ11724_0502 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();
   static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	   int N = Integer.parseInt(st.nextToken());
	   int M = Integer.parseInt(st.nextToken());
	   for(int i =0;i<N;i++) {
		   ArrayList<Integer> temp = new ArrayList<>();
		   graph.add(temp);
	   }
	   for(int i = 0;i<M;i++) {
		   st = new StringTokenizer(br.readLine(), " ");
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   graph.get(a).add(b);
		   graph.get(b).add(a);
	   }
	   
	   
   }
}
package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_27945_가지야미 {
	static int N, M;
	static int parent[];
	
	static ArrayList<Edge> graph = new ArrayList<>();
	
	
	static void init(int n) {
		parent = new int[n+1];
		for(int i= 0;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	
	static int find(int x) {
		if(parent[x] == x)return x;
		
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py)return false;
		
		parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		init(N);
		int first = 0;
		for(int i = 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			graph.add(new Edge(a,b,c));
			
		}
		
		Collections.sort(graph, (o1,o2)->o1.day-o2.day);
		int day = 1;
		for(int i =0;i<M;i++) {
			Edge cur = graph.get(i);
			
			if(union(cur.a,cur.b)) {
				if(day!=cur.day) {
					break;
				}
				day++;
			}
		}
		
		System.out.println(day);
		
		
		
	}
	
	static class Edge{
		int a;
		int b;
		int day;
		public Edge(int a, int b, int day) {
			this.a = a;
			this.b = b;
			this.day = day;
		}
		
		
	}
}

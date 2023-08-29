package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1368_물대기 {
	
	static int N, pools[], graph[][];
	
	
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pools = new int[N];
		graph = new int[N][N];
		
		for(int i =0;i<N;i++) {
			pools[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<N;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
	
//	static int dijkstra(int idx) {
//		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
//		pq.add(new Edge(idx,0));
//		
//		while(!pq.isEmpty()) {
//			Edge cur = pq.poll();
//			for(int i= 0;i<N;i++) {
//				
//			}
//		}
//		
//	}
	
	static class Edge{
		int n;
		int cost;
		
		
		public Edge(int n, int cost) {
			super();
			this.n = n;
			this.cost = cost;
		}
		
		
	}
}

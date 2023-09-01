package algorithm2023.sep.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static int N, M, X, max;
	static ArrayList<ArrayList<Edge>> edge = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i =0;i<=N;i++) {
			edge.add(new ArrayList<>());
		}
		for(int i= 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge.get(s).add(new Edge(e,cost));
		}
		
		int[] dijk = new int[N+1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[X] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		
		pq.add(new Edge(X,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			for(int j = 0;j<edge.get(cur.n).size();j++) {
				int next = cur.cost+edge.get(cur.n).get(j).cost;
				if(next<dijk[edge.get(cur.n).get(j).n]) {
					dijk[edge.get(cur.n).get(j).n] = next;
					pq.add(new Edge(edge.get(cur.n).get(j).n, next));
				}
			}
		}
		
		for(int i =1;i<=N;i++) {
			max = Math.max(max, dijkstra(i)+dijk[i]);
		}
		System.out.println(max);
		
	}
	
	static int dijkstra(int i) {
		if(i==X)return 0;
		int[] dijk = new int[N+1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[i] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		
		pq.add(new Edge(i,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			for(int j = 0;j<edge.get(cur.n).size();j++) {
				int next = cur.cost+edge.get(cur.n).get(j).cost;
				if(next<dijk[edge.get(cur.n).get(j).n]) {
					dijk[edge.get(cur.n).get(j).n] = next;
					pq.add(new Edge(edge.get(cur.n).get(j).n, next));
				}
			}
		}
		
		
		return dijk[X];
		
	}
	
	static class Edge{
		int n;
		int cost;
		public Edge(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
		
		
	}
}

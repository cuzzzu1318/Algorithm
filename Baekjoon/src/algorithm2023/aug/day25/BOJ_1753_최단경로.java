package algorithm2023.aug.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int V, E, K;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		K =Integer.parseInt(br.readLine());
		
		for(int i=0;i<=V;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i =0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Edge(b,c));
		}
		
		dijkstra(K);
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
		int[] dijk = new int[V+1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[start] = 0;
		pq.add(new Edge(start,0));
		boolean[] v = new boolean[V+1];
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(v[cur.node])continue;
			v[cur.node] = true;
			for(int i =0 ;i<graph.get(cur.node).size();i++) {
				int next = cur.cost+graph.get(cur.node).get(i).cost;
				if(next<dijk[graph.get(cur.node).get(i).node]) {
					dijk[graph.get(cur.node).get(i).node] = next;
					pq.offer(new Edge(graph.get(cur.node).get(i).node, next));
				}
			}
		}
		
		for(int i =1;i<=V;i++) {
			sb.append(dijk[i]==Integer.MAX_VALUE?"INF":dijk[i]).append("\n");
		}
	}
	
	static class Edge{
		int node;
		int cost;
		
		
		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		
	}
}

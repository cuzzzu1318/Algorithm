package algorithm2023.aug.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static int V, E, start, dijk[];
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//노드의 개수 V, 간선의 개수 E
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i= 0;i<=V;i++) {
			graph.add(new ArrayList<>());
		}
		dijk = new int[V+1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		//시작점
		start = Integer.parseInt(br.readLine());
		
		//그래프 입력
		for(int i= 0;i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u= Integer.parseInt(st.nextToken());
			int v= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			graph.get(u).add(new Node(v,w));
		}
		
		dijkstra(start);
		for(int i = 1;i<=V;i++) {
			sb.append(dijk[i]==Integer.MAX_VALUE?"INF":dijk[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.dist-o2.dist);
		dijk[start] = 0;
		q.add(new Node(start, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int num = cur.num;
			int dist = cur.dist;
			for(int i = 0;i<graph.get(num).size();i++) {
					int nDist = dist+graph.get(num).get(i).dist;
					if(nDist<dijk[graph.get(num).get(i).num]) {
						dijk[graph.get(num).get(i).num] = nDist;
						q.offer(new Node(graph.get(num).get(i).num,nDist));
					}
			}
		}
	}
	
	static class Node{
		int num;
		int dist;
		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
		
		
		
	}
}

package algorithm2023.sep.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static ArrayList<ArrayList<Integer>> adjList;
	static int min;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 1) {
						adjList.get(i).add(j);
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			for(int i =1;i<=N;i++) {
				bfs(i);
			}
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs(int V) {
		Queue<Node> queue = new  ArrayDeque<>();
		boolean[] visit = new boolean[N+1];
		
		visit[V] = true;
		queue.offer(new Node(V,0));
		
		int dist = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int v  : adjList.get(node.v)) {
				if(visit[v])continue;
				dist+=node.cnt+1;
				if(dist>=min)return;
				visit[v]=true;
				queue.offer(new Node(v,node.cnt+1));
			}
		}
		min = Math.min(min, dist);
	}
	
	static class Node{
		int v,cnt;

		public Node(int v, int cnt) {
			super();
			this.v = v;
			this.cnt = cnt;
		}
		
	}
}

package algorithm2023.aug.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static int n, m;
	static int[][] graph;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			if(graph[from][to]>0) {
				graph[from][to] = Math.min(graph[from][to], dist);
			}else {
				graph[from][to] = dist;
			}
			
		}
		
		for (int i = 1; i <= n; i++) {
			dijkstra(i);
		}

		System.out.println(sb);
	}

	static void dijkstra(int idx) {
		long[] dijk = new long[n + 1];
		Arrays.fill(dijk, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

		pq.add(new Node(idx, 0));
		dijk[idx] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			for (int i = 1; i <= n; i++) {
				if (graph[cur.num][i] > 0) {
					if (cur.dist + graph[cur.num][i] < dijk[i]) {
						dijk[i] = cur.dist + graph[cur.num][i];
						pq.add(new Node(i, cur.dist + graph[cur.num][i]));
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			sb.append(dijk[i] == Integer.MAX_VALUE ? 0 : dijk[i]).append(" ");
		}
		sb.append("\n");

	}

	static class Node {
		int num;
		int dist;

		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}

	}
}

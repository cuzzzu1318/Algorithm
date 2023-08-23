package algorithm2023.aug.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {
	static int V, E;

	static ArrayList<Edge> edge;

	static StringBuilder sb = new StringBuilder();

	static int[] parent;

	static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i;
		}
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py)
			return false;
		parent[find(x)] = parent[find(y)];

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edge = new ArrayList<>();
			makeSet();
			long sum = 0;

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edge.add(new Edge(start, end, cost));
			}

			Collections.sort(edge, (o1, o2) -> {
				return o1.cost - o2.cost;
			});

			int cnt = 0;
			int idx = 0;

			while (cnt != V - 1) {
				Edge cur = edge.get(idx++);
				int s = cur.start;
				int e = cur.end;
				int c = cur.cost;

				if (union(s, e)) {
					sum += c;
					cnt++;
				}
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);

	}

	static class Edge {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			super();
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]\n";
		}

	}
}

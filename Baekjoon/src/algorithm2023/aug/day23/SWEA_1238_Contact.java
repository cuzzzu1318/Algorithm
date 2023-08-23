package algorithm2023.aug.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int N, start;
	static ArrayList<ArrayList<Integer>> graph;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();

			for (int i = 0; i <= 100; i++) {
				graph.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
			}

			Queue<Integer> q = new LinkedList<>();
			boolean[] v = new boolean[101];
			q.add(start);
			v[start] = true;
			int last = 0;
			while (!q.isEmpty()) {
				last = 0;
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int cur = q.poll();
					last = Math.max(last, cur);
					for (int i = 0; i < graph.get(cur).size(); i++) {
						int next = graph.get(cur).get(i);
						if (v[next])
							continue;
						q.offer(next);
						v[next] = true;
					}
				}

			}

			sb.append("#").append(t).append(" ").append(last).append("\n");
		}
		System.out.println(sb);

	}
}

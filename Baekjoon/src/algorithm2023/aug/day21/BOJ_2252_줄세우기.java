package algorithm2023.aug.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
		}

		int[] indegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				indegree[graph.get(i).get(j)]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}

		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");

			for (int i = 0; i < graph.get(cur).size(); i++) {
				if (--indegree[graph.get(cur).get(i)] == 0) {
					q.offer(graph.get(cur).get(i));
				}
			}
		}
		System.out.println(sb);

	}
}

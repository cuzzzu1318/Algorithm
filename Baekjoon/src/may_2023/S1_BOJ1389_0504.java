package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_BOJ1389_0504 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// 인간관계 저장할 그래프

		int[] kb = new int[N + 1];
		// 케빈베이컨 수 저장할 배열
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			graph.add(arr);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}//입력 및 양방향 그래프 연결
		
		
		for (int i = 1; i < N + 1; i++) {
			//모든 노드에 대해 bfs 진행
			Queue<Integer> q = new LinkedList<>();
			//bfs에 사용될 큐
			q.add(i);
			//출발점 큐에 삽입
			int cnt = 1;
			boolean[] v = new boolean[N + 1];
			v[i] = true;
			while (!q.isEmpty()) {
				//bfs
				int size = q.size();
				for (int l = 0; l < size; l++) {
					//큐의 크기만큼 반복함으로써 큐의 level 알아냄
					int n = q.poll();
					for (int j = 0; j < graph.get(n).size(); j++) {
						if (!v[graph.get(n).get(j)]) {
							v[graph.get(n).get(j)] = true;
							kb[i] += cnt;
							q.add(graph.get(n).get(j));
						}
					}
				}
				
				cnt++;
				//깊이가 늘어나므로 케빈 베이컨수에 더해 줄 수 또한 증가

			}
		}
		int min = 5000;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (min > kb[i]) {
				//최소의 케빈 베이컨수를 갖는 인덱스 탐색
				min = kb[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

}
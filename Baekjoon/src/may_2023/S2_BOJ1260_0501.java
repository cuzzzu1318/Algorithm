package may_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_BOJ1260_0501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		// 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// 그래프를 이중 리스트로 저장
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			graph.add(a);
		}
		// 빈 리스트로 초기화. 정점 번호는 1번부터 N번이므로 N+1번 반복

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
			// 그래프 간 서로 간선 연결
		}
		for(int i= 0;i<N+1;i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		//작은 노드부터 탐색하기 위한 정렬
		
		
		Stack<Integer> dfs = new Stack<>();
		//dfs에 사용될 스택
		boolean[] v = new boolean[N + 1];
		//방문한 노드 기록 배열
		dfs.add(V);
		while (!dfs.isEmpty()) {
			//스택을 이용한 dfs 구현
			int n = dfs.pop();
			if (!v[n]) {
				sb.append(n+" ");
				v[n] = true;
				
				for (int i = 0; i < graph.get(n).size(); i++) {
					if (!v[graph.get(n).get(i)]) {
						dfs.push(graph.get(n).get(i));
					}
				}
			}
		}
		sb.append("\n");
		v = new boolean[N+1];
		Queue<Integer> bfs = new LinkedList<>();
		//방문 배열 초기화 및 bfs에 사용할 큐
		bfs.add(V);
		while (!bfs.isEmpty()) {
			//큐를 이용한 bfs 구현
			int n = bfs.poll();
			if (!v[n]) {
				sb.append(n+" ");
				v[n] = true;
				for (int i = graph.get(n).size()-1; i >=0 ; i--) {
					if (!v[graph.get(n).get(i)]) {
						bfs.add(graph.get(n).get(i));
					}
				}
			}
		}
		
		
		System.out.println(sb);

	}
}
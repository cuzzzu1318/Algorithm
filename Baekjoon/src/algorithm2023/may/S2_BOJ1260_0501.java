package algorithm2023.may;

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
		// ������ ���� N, ������ ���� M, Ž���� ������ ������ ��ȣ V

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// �׷����� ���� ����Ʈ�� ����
		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> a = new ArrayList<>();
			graph.add(a);
		}
		// �� ����Ʈ�� �ʱ�ȭ. ���� ��ȣ�� 1������ N���̹Ƿ� N+1�� �ݺ�

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
			// �׷��� �� ���� ���� ����
		}
		for(int i= 0;i<N+1;i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		//���� ������ Ž���ϱ� ���� ����
		
		
		Stack<Integer> dfs = new Stack<>();
		//dfs�� ���� ����
		boolean[] v = new boolean[N + 1];
		//�湮�� ��� ��� �迭
		dfs.add(V);
		while (!dfs.isEmpty()) {
			//������ �̿��� dfs ����
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
		//�湮 �迭 �ʱ�ȭ �� bfs�� ����� ť
		bfs.add(V);
		while (!bfs.isEmpty()) {
			//ť�� �̿��� bfs ����
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
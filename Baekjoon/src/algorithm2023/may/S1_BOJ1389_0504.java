package algorithm2023.may;

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
		// �ΰ����� ������ �׷���

		int[] kb = new int[N + 1];
		// �ɺ����� �� ������ �迭
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
		}//�Է� �� ����� �׷��� ����
		
		
		for (int i = 1; i < N + 1; i++) {
			//��� ��忡 ���� bfs ����
			Queue<Integer> q = new LinkedList<>();
			//bfs�� ���� ť
			q.add(i);
			//����� ť�� ����
			int cnt = 1;
			boolean[] v = new boolean[N + 1];
			v[i] = true;
			while (!q.isEmpty()) {
				//bfs
				int size = q.size();
				for (int l = 0; l < size; l++) {
					//ť�� ũ�⸸ŭ �ݺ������ν� ť�� level �˾Ƴ�
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
				//���̰� �þ�Ƿ� �ɺ� ���������� ���� �� �� ���� ����

			}
		}
		int min = 5000;
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			if (min > kb[i]) {
				//�ּ��� �ɺ� ���������� ���� �ε��� Ž��
				min = kb[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

}
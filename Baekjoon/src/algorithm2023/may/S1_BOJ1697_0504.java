package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_BOJ1697_0504 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//�������� ��ġ N, ������ ��ġ k
		Queue<Integer> q = new LinkedList<>();
		//BFS�� ���� ť
		boolean[] v = new boolean[100001];
		//�̹� Ž���� ��ġ�� ����ϱ� ���� �迭
		q.add(N);
		int cnt = 0;
		loop:
		while (!q.isEmpty()) {
			//BFS
			int size = q.size();
			for (int l = 0; l < size; l++) {
				//�� ������ ���� ���� level�� �˱� ���� �ݺ��� �߰�
				int n = q.poll();
				if (v[n]) {
					continue;
				}
				if(n==K) {
					//K�� ã���� while�� ����
					break loop;
				}
				v[n] = true;
				int[] next = { n - 1, n + 1, n * 2 };
				//Ž���� ��ġ �迭
				for (int i = 0; i < 3; i++) {
					if(next[i]>=0&&next[i]<=100000) {
						//0�� 100000 ���̿� �ִ� ���� Ž��
						q.add(next[i]);
					}
					
				}
			}
			
			cnt++;
			//�ѹ��� Ž���� ��ġ�� 1�� �߰�
		}
		System.out.println(cnt);
	}
}
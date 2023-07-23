package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1_BOJ11286_0510 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> {
			if (Math.abs(e1) < Math.abs(e2)) {
				//e1�� ������ �� �۴ٸ� ���� ��ȯ
				return Math.abs(e1) - Math.abs(e2);
			} else if (Math.abs(e1) == Math.abs(e2)) {
				//������ ���ٸ� ũ�⸦ ��
				return e1-e2;
			} else {
				//������ ũ�ٸ� ��� ��ȯ
				return 1;
			}
		});
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				//0�̸�
				if (q.isEmpty()) {
					//ť�� ����ٸ� 0 ���
					sb.append("0\n");
				} else {
					//���Ұ� �ִٸ� �ش� ���� ��� �� ����
					sb.append(q.poll() + "\n");
				}
			} else {
				//0�� �ƴϸ� n�� ť�� �߰�
				q.add(n);
			}
		}
		System.out.println(sb);
	}
}
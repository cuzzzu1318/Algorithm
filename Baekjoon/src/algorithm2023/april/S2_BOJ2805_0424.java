package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_BOJ2805_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long[] trees;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		trees = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		// �Է� �� �ִ� ���ϱ�.

		long h = sawTree(0, max, N, M);
		bw.write(Long.toString(h));

		bw.flush();
		bw.close();

	}

	static long sawTree(long l, long max, int N, int M) {
		long cnt = 0;
		//�ش� �߾Ӱ����� ���� �� �ִ� ������ ��
		long middle = (max + l) / 2;
		//�߾Ӱ�
		for (int i = 0; i < N; i++) {
			//���� �迭�� ���鼭
			if (trees[i] > middle) {
				//������ �߾Ӱ����� ��ٸ� �߶��� �� ���� �� �ִ� �� ���.
				cnt += trees[i] - middle;
			}
		}
		if (l >= max) {
			//�ּڰ��� �ִ񰪺��� ũ�ų� �۴� -> ���̻� �̺��� �� ����. -> ����
			return middle - 1;
		} else {
			if (cnt < M) {
				//������ �� �߶�� �ϸ�
				return sawTree(l, middle, N, M);
				//�Ʒ����� �߶�� �ϹǷ� �ּڰ��� �߾Ӱ����� �ٽ� ���
			} else {
				//������ �� �߶�� �ϸ�
				return sawTree(middle + 1, max, N, M);
				//������ �߶�� �ϹǷ� �߾Ӱ�+1�� �ִ����� �ٽ� ���
			}
		}
	}
}
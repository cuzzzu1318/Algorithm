package algorithm2023.may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2_BOJ1780_0501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		// N*Nũ���� ����

		int[][] paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(s[j]);
			}
		}
		// ���� �� �Է�

		int[] idx = { 0, 0 };
		int[] papers = isPaper(paper, idx, N);
		// ���� �ε��� �� -1,0,1 ������ ����
		System.out.println(papers[0] + " " + papers[1] + " " + papers[2]);

	}

	static int[] isPaper(int[][] paper, int[] start, int l) {
		int cnt[] = new int[3];
		// -1, 0, 1 ������ ��츦 ��� �����ϱ� ���� �迭
		int n = paper[start[0]][start[1]];
		// ���� ���� ���� ���ڸ� �������� ���ϱ� ���� ����
		boolean isPaper = true;
		// �ϳ��� �������� �ƴ��� �Ǻ��� ����
		loop: for (int i = start[0]; i < start[0] + l; i++) {
			for (int j = start[1]; j < start[1] + l; j++) {
				// ���̸� l*l��ŭ Ž���ϸ�
				if (paper[i][j] != n) {
					// n�� �ٸ��ٸ� �ϳ��� ���̰� �ƴ϶�� �Ǵ� �� ���� ����
					isPaper = false;
					break loop;
				}
			}
		}
		if (isPaper) {
			// �ϳ��� ���̶�� �ش� ���� +1, -1���� �����ϱ� ������ n+1�� ����
			cnt[n + 1]++;
		} else {
			// �ϳ��� ���̰� �ƴ϶�� 9���
			for (int i = start[0]; i < start[0] + l; i += l / 3) {
				for (int j = start[1]; j < start[1] + l; j += l / 3) {
					int[] temp = { i, j };
					temp = isPaper(paper, temp, l / 3);
					// i,j���� l/3���̸�ŭ�� ���̷� �ٽ� ���
					cnt[0] += temp[0];
					cnt[1] += temp[1];
					cnt[2] += temp[2];
				}
			}
		}

		return cnt;

	}

}
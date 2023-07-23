package algorithm2023.may;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S2_BOJ2630_0502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] paper;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i = 0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j =0;j<N;j++) {
				paper[i][j] = Integer.parseInt(s[j]);
			}
		}
		//�Է�
		int[] idx = {0,0};
		//���� �ε���
		int[] papers = isPaper(paper, idx, N);
		//���� ���� ��ȯ
		sb.append(papers[0]+"\n");
		sb.append(papers[1]+"\n");
		System.out.println(sb);
	}
	
	static int[] isPaper(int[][] paper, int[] start, int l) {
		int cnt[] = new int[2];
		// 0, 1 ������ ��츦 ��� �����ϱ� ���� �迭
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
			// �ϳ��� ���̶�� �ش� ���� ����
			cnt[n]++;
		} else {
			// �ϳ��� ���̰� �ƴ϶�� 4���
			for (int i = start[0]; i < start[0] + l; i += l / 2) {
				for (int j = start[1]; j < start[1] + l; j += l / 2) {
					int[] temp = { i, j };
					temp = isPaper(paper, temp, l / 2);
					// i,j���� l/2���̸�ŭ�� ���̷� �ٽ� ���
					cnt[0] += temp[0];
					cnt[1] += temp[1];
				}
			}
		}
		return cnt;

	}
}
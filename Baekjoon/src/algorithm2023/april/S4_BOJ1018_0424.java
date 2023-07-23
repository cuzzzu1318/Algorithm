package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_BOJ1018_0424 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j].equals("W") ? (i + j) % 2 : (i + j + 1) % 2;
				//���� ���� �ε����� ���� ¦���̸鼭 ���� W�� �ƴ϶�� 1 ����
			}
		}
		int min = 64;
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				//i,j��ġ���� 8*8 Ž���ؼ� 1�� ���� ���� �ּڰ� ����
				min = Math.min(min, count(i, j));
			}
		}
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}

	static int count(int x, int y) {
		//1�� ���� ���� �Լ�
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				cnt += map[i][j];
			}
		}
		if (cnt > 32) {
			//���� �̻��� �ٲ�� �Ѵٸ� ù ���ڰ� "B"�� ���� ���
			cnt = 64 - cnt;
		}

		return cnt;
	}
}
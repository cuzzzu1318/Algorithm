package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S4_BOJ1388_0420 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] room = new char[N][M];
		// ���� ũ�� N, ���� ũ�� M ��

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				room[i][j] = temp[j];
			}
		}
		// �Է� �Ϸ�

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				switch (room[i][j]) {
				case '|':
					// ���� �����϶�
					if (i == 0) {
						// ù��° ���� ��
						cnt++;
					} else if (room[i - 1][j] != '|') {
						// ���� �� �ٷ� �� ���ڰ� �ٸ� ������ ��
						cnt++;
					}
					break;
				default:
					// ���� �����϶�
					if (j == 0) {
						// ù��° ���϶�
						cnt++;
					} else if (room[i][j - 1] != '-') {
						// ���� �� �ٷ� ���� ���ڰ� �ٸ� ������ ��
						cnt++;
					}
				}
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
	}
}
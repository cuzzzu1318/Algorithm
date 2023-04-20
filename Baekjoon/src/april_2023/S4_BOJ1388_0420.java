package april_2023;

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
		// 세로 크기 N, 가로 크기 M 방

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				room[i][j] = temp[j];
			}
		}
		// 입력 완료

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				switch (room[i][j]) {
				case '|':
					// 세로 판자일때
					if (i == 0) {
						// 첫번째 행일 때
						cnt++;
					} else if (room[i - 1][j] != '|') {
						// 같은 열 바로 윗 판자가 다른 판자일 때
						cnt++;
					}
					break;
				default:
					// 가로 판자일때
					if (j == 0) {
						// 첫번째 열일때
						cnt++;
					} else if (room[i][j - 1] != '-') {
						// 같은 행 바로 왼쪽 판자가 다른 판자일 때
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
package mar_2023;

/*  왼쪽아래부터 관객에게 좌석 번호를 시계방향으로 배정해 줄때 대기번호 K인 관객의 좌석번호
 * 난이도 : 실버4
 * 아이디어: 달팽이
 * 시간복잡도:
 * 소요 시간: 14:10~ 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10157 {

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int C = Integer.parseInt(s[0]);
		// 가로
		int R = Integer.parseInt(s[1]);
		// 세로
		int K = Integer.parseInt(br.readLine());
		// 대기번호
		if (K > R * C) {
			bw.write("0");
		} else {
			int[][] hall = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					hall[i][j] = 0;
				}
			}
			int x = R - 1;
			int y = 0;
			// 처음 배정되는 자리 왼쪽 아래
			int d = 0;
			// 방향벡터 인덱스

			for (int i = 1; i <= K; i++) {
				hall[x][y] = i;
				if (i == K) {
					break;
				}
				int nextX = x + dx[d];
				int nextY = y + dy[d];
				if (nextX >= R || nextX < 0 || nextY >= C || nextY < 0 || hall[nextX][nextY] != 0) {
					d++;
					if (d > 3) {
						d = 0;
					}
					nextX = x + dx[d];
					nextY = y + dy[d];
				}
				x = nextX;
				y = nextY;
			}
		/*
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					bw.write(hall[i][j] + " ");
				}
				bw.write("\n");
			}
			*/
			int temp = x;
			x = y + 1;
			y = R - temp;
			bw.write(x + " " + y + "\n");
		}
		bw.flush();
		bw.close();
	}
}
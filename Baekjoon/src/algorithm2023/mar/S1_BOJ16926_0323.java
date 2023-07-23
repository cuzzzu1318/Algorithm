package algorithm2023.mar;

/*  �迭 ������. 
 * ���̵� : �ǹ� 1
 * ���̵��: �ӽù迭 ���� �ߴµ� �ð��̶� �޸𸮰� �ڻ쳪����. ����Ѱ� �ű��� ����.
 * �ð����⵵:
 * �ҿ� �ð�: 16:50~19:50(����ð� ���� 1h 30min ����)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S1_BOJ16926_0323 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int min;
	static int R;
	static int[][] map;
	static int[][] ans;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[] turnIdx(int x, int y, int depth, int r) {
		int[] idx = new int[2];
		idx[0] = x;
		idx[1] = y;
		int minX = 0 + depth;
		int maxX = N - 1 - depth;
		int minY = 0 + depth;
		int maxY = M - 1 - depth;

		if (y == minY) {
			if (x == maxX) {
				idx[0] += dx[1];
				idx[1] += dy[1];
			} else {
				idx[0] += dx[0];
				idx[1] += dy[0];
			}

		} else if (x == maxX) {
			if (y == maxY) {
				idx[0] += dx[2];
				idx[1] += dy[2];
			} else {
				idx[0] += dx[1];
				idx[1] += dy[1];
			}

		} else if (y == maxY) {
			if (x == minX) {
				idx[0] += dx[3];
				idx[1] += dy[3];
			} else {
				idx[0] += dx[2];
				idx[1] += dy[2];
			}
		} else {
			idx[0] += dx[3];
			idx[1] += dy[3];
		}
		if (r > 1) {
			idx = turnIdx(idx[0], idx[1], depth, r - 1);
		}

		return idx;
	}

	static int retD(int x, int y) {
		int depth = 0;
		for (; depth <= min / 2; depth++) {
			int minX = 0 + depth;
			int maxX = N - 1 - depth;
			int minY = 0 + depth;
			int maxY = M - 1 - depth;
			if (x == minX || x == maxX || y == minY || y == maxY) {
				break;
			}
		}

		return depth;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		min = Math.min(N, M);
		R = Integer.parseInt(s[2]);
		map = new int[N][M];
		ans = new int[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {

				int[] idx = turnIdx(i, j, retD(i, j), R);
				ans[idx[0]][idx[1]] = Integer.parseInt(s[j]);
				//System.out.println(retD(i, j) + " " + idx[0] + " " + idx[1]);
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(ans[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
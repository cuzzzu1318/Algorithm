package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R, C, cnt;
	static boolean[][] map;

	static int dy[] = { -1, 0, 1 };
	// dx는 전부 1이므로 만들지 않음

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = s[j] == '.' ? true : false;
			}
		}

		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		System.out.println(cnt);
	}

	static boolean pipe(int y, int x) {
		if (x == C - 1) {
			cnt++;
			return true;
		}
		for (int d = 0; d < 3; d++) {
			int ny = y + dy[d];
			int nx = x + 1;
			if (!isValid(ny, nx))
				continue;
			map[ny][nx] = false;
			if (pipe(ny, nx)) {
				return true;
			}
		}
		return false;
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || y >= R || x >= C || !map[y][x])
			return false;
		return true;
	}
}

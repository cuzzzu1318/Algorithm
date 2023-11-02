package algorithm2023.nov.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20056_마법사_상어와_파이어볼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, K;
	static List<Fire>[][] board;
	static ArrayList<Fire> fire = new ArrayList<>();

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static class Fire {
		int r, c, m, s, d;

		public Fire(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new ArrayList[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Fire f = new Fire(r, c, m, s, d);
			fire.add(f);
			board[r][c].add(f);
		}

		for (int i = 0; i < K; i++) {

			// 모든 파이어볼이 자신의 방향 d로 속력 s칸만큼 이동.
			move();
			// 같은 칸에 있는 파이어볼 합쳐졌다가 4개로 나뉨.
			findMerge();
		}
		System.out.println(cnt());

	}

	static void move() {
		for (Fire f : fire) {
			board[f.r][f.c].remove(f);
			f.r = (f.r + N + (dy[f.d] * (f.s % N))) % N;
			f.c = (f.c + N + (dx[f.d] * (f.s % N))) % N;
			board[f.r][f.c].add(f);

		}
	}

	static void findMerge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].size() > 1) {
					merge(i, j);
				}
			}
		}
	}

	static void merge(int y, int x) {
		int mSum = 0, sSum = 0, cnt = board[y][x].size();
		boolean odd = true, even = true;
		for (Fire f : board[y][x]) {
			mSum += f.m;
			sSum += f.s;
			if (f.d % 2 == 0) {
				odd = false;
			} else {
				even = false;
			}
			board[y][x].remove(f);
			fire.remove(f);
		}
		int m = mSum / 5;
		if (m == 0)
			return;
		int s = sSum / cnt;
		int d = 1;
		if (odd || even)
			d = 0;
		for (int i = 0; i < 4; i++) {
			Fire f = new Fire(y, x, m, s, d + 2 * i);
			board[y][x].add(f);
			fire.add(f);
		}
	}

	static int cnt() {
		int cnt = 0;
		for (Fire f : fire) {
			cnt += f.m;
		}
		return cnt;
	}
}

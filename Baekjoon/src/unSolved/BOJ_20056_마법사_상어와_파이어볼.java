package unSolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20056_마법사_상어와_파이어볼 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, K;
	static Fire[][] board;
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

		board = new Fire[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Fire f = new Fire(r,c,m,s,d);
			fire.add(f);
			board[r][c] = f;
		}

		for (int i = 0; i < K; i++) {

			// 모든 파이어볼이 자신의 방향 d로 속력 s칸만큼 이동.

			// 같은 칸에 있는 파이어볼 합쳐졌다가 4개로 나뉨.

			// 질량이 0인 파이어볼은 소멸
		}

	}

	static void move() {
		for (Fire f : fire) {
			int nr = f.r;
			int nc = f.c;

		}
	}

	static void merge() {

	}

	static void divide(int W, boolean isEven) {

	}

	static void destroy() {
		for (int i = fire.size() - 1; i >= 0; i--) {
			if (fire.get(i).m == 0)
				fire.remove(i);
		}
	}
}

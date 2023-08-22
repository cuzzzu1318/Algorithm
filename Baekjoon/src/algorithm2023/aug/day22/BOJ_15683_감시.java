package algorithm2023.aug.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	static int N, M, office[][];
	static int min = Integer.MAX_VALUE;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	
	static int[][] w;

	static ArrayList<Idx> cctv = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		w = new int[N][M];
		office = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] != 0 && office[i][j] != 6) {
					cctv.add(new Idx(i, j));
				}
			}
		}
		area(0);
		System.out.println(min);
	}

	static void area(int ctIdx) {
		if (ctIdx == cctv.size()) {
			min = Math.min(min, count());
			return;
		}
		int y = cctv.get(ctIdx).y;
		int x = cctv.get(ctIdx).x;
		switch (office[y][x]) {
		case 1:
			for (int d = 0; d < 4; d++) {
				watch(y, x, d);
				area(ctIdx + 1);
				remove(y,x,d);
			}
			break;
		case 2:
			for (int d = 0; d < 2; d++) {
				watch(y, x, d);
				watch(y, x, d + 2);
				area(ctIdx + 1);
				remove(y,x,d);
				remove(y,x,d+2);
			}
			break;
		case 3:
			for (int d = 0; d < 4; d++) {
				watch(y, x, d);
				watch(y, x, (d + 1) % 4);
				area(ctIdx + 1);
				remove(y,x,d);
				remove(y,x,(d+1)%4);
			}
			break;
		case 4:
			for (int d = 0; d < 4; d++) {
				watch(y, x, d);
				watch(y, x, (d+1)%4);
				watch(y, x, (d+2)%4);
				area(ctIdx + 1);
				remove(y,x,d);
				remove(y,x,(d+1)%4);
				remove(y,x,(d+2)%4);
			}
			break;
		case 5:
			watch(y, x, 0);
			watch(y, x, 1);
			watch(y, x, 2);
			watch(y, x, 3);
			area(ctIdx + 1);
			remove(y,x,0);
			remove(y,x,1);
			remove(y,x,2);
			remove(y,x,3);
			
		}
	}
	static void remove(int y, int x, int d) {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (!isValid(ny, nx) || office[ny][nx] == 6)
				break;
			if(w[ny][nx]>0)w[ny][nx]--;
		}
	}

	static void watch(int y, int x, int d) {
		int ny = y;
		int nx = x;
		while (true) {
			ny += dy[d];
			nx += dx[d];
			if (!isValid(ny, nx) || office[ny][nx] == 6)
				break;
			if (office[ny][nx] == 0)
				w[ny][nx]++;
		}
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M)
			return false;
		return true;
	}

	static int count() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (office[i][j] == 0&&w[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}

	static class Idx {
		int y;
		int x;

		public Idx(int y, int x) {
			this.y = y;
			this.x = x;
		}
		

	}
}

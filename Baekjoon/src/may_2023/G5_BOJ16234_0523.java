package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_BOJ16234_0523 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N + 2][N + 2];
		boolean[][] v = new boolean[N + 2][N + 2];

		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(map[i], -1);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 2001;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!v[i][j]) {
					ArrayList<idx> region = new ArrayList<>();
					int cnt = 1;
					int sum = map[i][j];
					int day = 0;
					Queue<idx> q = new LinkedList<>();
					idx start = new idx(i, j);
					region.add(start);
					q.add(start);
					v[i][j] = true;
					while (!q.isEmpty()) {
						int sz = q.size();
						boolean canOpen = false;
						for (int s = 0; s < sz; s++) {
							idx cur = q.poll();
							for (int d = 0; d < 4; d++) {
								int x = cur.x + dx[d];
								int y = cur.y + dy[d];

								int diff = Math.abs(map[cur.x][cur.y] - map[x][y]);
								if (map[x][y] == -1) {
									continue;
								}
								if (!v[x][y] && diff >= L && diff <= R) {
									v[x][y] = true;
									idx next = new idx(x, y);
									q.add(next);
									region.add(next);
									sum += map[x][y];
									cnt++;
									canOpen = true;
								}
							}

						}
						if (canOpen) {
							day++;
						}
					}
					System.out.println(day);
					for (idx r : region) {
						map[r.x][r.y] = sum / cnt;
					}
					if(day>0) {
						days = Math.min(days, day);
					}
				}
			}
		}
		if(days==2001) {
			days = 0;
		}
		System.out.println(days);
	}

	static class idx {
		int x;
		int y;

		idx(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
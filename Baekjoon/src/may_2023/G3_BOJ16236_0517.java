package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_BOJ16236_0517 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] sea = new int[N + 2][N + 2];
		for (int i = 0; i < N + 2; i++) {
			Arrays.fill(sea[i], -1);
		}
		idx shark = new idx();
		int size = 2;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					shark.x = i;
					shark.y = j;
				}
			}
		}
		boolean[][] v = new boolean[N + 2][N + 2];
		Queue<idx> q = new LinkedList<>();
		q.add(shark);
		v[shark.x][shark.y] = true;
		int time = 0;
		int fish = 0;
		loop: while (!q.isEmpty()) {
			int S = q.size();
			for (int s = 0; s < S; s++) {
				idx cur = q.poll();
				System.out.println(cur.x + " " + cur.y);
				for (int i = 0; i < 4; i++) {
					int x = cur.x + dx[i];
					int y = cur.y + dy[i];
					if (sea[x][y] != -1 && !v[x][y]) {
						q.add(new idx(x, y));
						v[x][y] = true;
						if (sea[x][y] > 0) {
							if (sea[x][y] > size) {
								break loop;
							} else if (sea[x][y] == size) {
								size++;
							}
							fish++;
						}
					}
				}
			}
			System.out.println();
			time++;
		}
		if (fish == 0) {
			sb.append(0);
		} else {
			sb.append(--time);
		}
		System.out.println(sb);
	}

	static class idx {
		int x;
		int y;

		idx(int x, int y) {
			this.x = x;
			this.y = y;
		}

		idx() {
			this.x = 0;
			this.y = 0;
		}
	}

}
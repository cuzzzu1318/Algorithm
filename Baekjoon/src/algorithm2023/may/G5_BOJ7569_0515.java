package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_BOJ7569_0515 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 0, 1, 0 };
	static int[] dz = { 0, 0, 0, 1, 0, -1 };
	static int[][][] tomato;
	static int N;
	static int M;
	static int H;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[H + 2][N + 2][M + 2];
		for (int i = 0; i < H + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				Arrays.fill(tomato[i][j], -1);
			}
		}

		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 1; m <= M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken()) - 1;
					if (tomato[h][n][m] == -1) {
						tomato[h][n][m] = 1000000;
					}
				}
			}
		}
		int max = 0;
		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= M; m++) {
					if (tomato[h][n][m] == 0) {
						Queue<int[]> q = new LinkedList<>();
						int[] idx = new int[3];
						idx[0] = h;
						idx[1] = n;
						idx[2] = m;

						q.add(idx);
						int cnt = 0;
						while (!q.isEmpty()) {
							int size = q.size();
							for (int s = 0; s < size; s++) {
								int[] cur = q.poll();
								for (int i = 0; i < 6; i++) {
									int[] next = new int[3];
									next[0] = cur[0] + dx[i];
									next[1] = cur[1] + dy[i];
									next[2] = cur[2] + dz[i];
									if (tomato[next[0]][next[1]][next[2]] > cnt+1) {
										q.add(next);
										tomato[next[0]][next[1]][next[2]] = cnt+1;
									}
								}
							}
							cnt++;
						}
					}
				}
			}
		}
		loop: for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					if(tomato[i][j][k]>max) {
						max = tomato[i][j][k];
					}
				}
			}
		}
		if (max!=1000000) {
			sb.append(max);
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}
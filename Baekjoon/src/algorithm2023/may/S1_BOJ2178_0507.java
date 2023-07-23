package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_BOJ2178_0507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N + 2][M + 2];
		for (int i = 1; i <= N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(s[j - 1]);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		boolean[][] v = new boolean[N + 2][M + 2];
		int[] idx = { 1, 1 };
		q.add(idx);
		v[1][1] = true;
		int cnt = 0;
		loop:
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] a = q.poll();
				int x = a[0];
				int y = a[1];
				if (x == N && y == M) {
					cnt++;
					break loop;
				}
				for (int i = 0; i < 4; i++) {
					int[] temp = new int[2];
					temp[0] = x + dx[i];
					temp[1] = y + dy[i];
					if (maze[temp[0]][temp[1]] == 1 && (!v[temp[0]][temp[1]])) {
						v[temp[0]][temp[1]] = true;
						q.offer(temp);
					}
				}
			}
			cnt++;
		}
		System.out.println(cnt);

	}
}
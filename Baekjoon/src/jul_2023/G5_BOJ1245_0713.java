package jul_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_BOJ1245_0713 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] dy = { -1, 0, 1, 0, -1,-1,1,1};
	static int[] dx = { 0, 1, 0, -1, -1,1,1,-1};
	static int cnt = 0;

	static boolean canAccess(int N, int M, int y, int x) {
		if(x<0||y<0||x>=M||y>=N) {
			return false;
		}
		return true;
	}
	
	
	static void debug(int N, int M, boolean[][] v) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(!canAccess(N,M,y,x)) {
					continue;
				}
				if (v[y][x]) {
					System.out.print("* ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		int[][] farm = new int[N][M];
		boolean[][] v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!canAccess(N, M, j, i)) {
					continue;
				}
				if (!v[i][j]) {
					cntPeak(N, M, farm, j, i, v);
					//debug(N, M, v);
				}
			}
		}
		System.out.println(cnt);

	}

	static void cntPeak(int N, int M, int[][] farm, int x, int y, boolean[][] v) {
		cnt++;
		Queue<idx2> q = new LinkedList<>();
		idx2 start = new idx2(x, y);
		q.add(start);
		v[y][x] = true;
		while (!q.isEmpty()) {
			idx2 cur = q.poll();
			for (int d = 0; d < 8; d++) {
				int nextX = cur.x + dx[d];
				int nextY = cur.y + dy[d];
				
				if(!canAccess(N, M, nextY,nextX)) {
					//System.out.println(nextY+" "+nextX);
					continue;
				}
				if (farm[cur.y][cur.x]-farm[nextY][nextX]>=0&& !v[nextY][nextX]) {
					q.offer(new idx2(nextX, nextY));
					v[nextY][nextX] = true;
				}
			}
		}
	}

}

class idx2 {
	int x;
	int y;

	public idx2(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
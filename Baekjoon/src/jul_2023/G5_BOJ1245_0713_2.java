package jul_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_BOJ1245_0713_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int[] dy = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dx = { 0, 1, 0, -1, -1, 1, 1, -1 };

	static int N;
	static int M;
	static int[][] farm;
	static boolean[][] v;
	static int cnt = 0;
	static boolean isPeak = true;

	static boolean canAccess(int y, int x) {
		// Boundary 검사
		if (x < 0 || y < 0 || y >= N || x >= M) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		farm = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				farm[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		//여기까지 입력
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				//모든 격자를 탐색
				if (!v[y][x]) {
					//방문하지 않았다면 
					isPeak = true;
					//꼭대기라고 가정하고 
					bfs(y, x);
					//bfs 
					if (isPeak) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);

	}

	static void bfs(int y, int x) {
		//bfs
		Queue<idx> q = new LinkedList<>();
		idx start = new idx(x, y);
		q.add(start);
		v[y][x] = true;
		while (!q.isEmpty()) {
			idx cur = q.poll();
			for (int d = 0; d < 8; d++) {
				//8방향 탐색
				int nextY = cur.y + dy[d];
				int nextX = cur.x + dx[d];
				if (canAccess(nextY, nextX)) {
					//Boundary 내의 값이라면
					if (farm[nextY][nextX] > farm[cur.y][cur.x]) {
						//주위에 더 큰 값이 있다면 꼭대기 아님.
						isPeak = false;
					}
					if (!v[nextY][nextX]) {
						if (farm[nextY][nextX] == farm[cur.y][cur.x]) {
							//방문한 적 없는 노드면서 같은 높이라면 큐에 추가
							q.offer(new idx(nextX, nextY));
							v[nextY][nextX] = true;
						}
					}

				}
			}
		}
	}
}

class idx {
	int x;
	int y;

	idx(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
package algorithm2023.aug.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {
	static int K, W, H, map[][];
	static boolean[][][] v;

	static int[][] monkeyD = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] horseD = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		v = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();

	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<>();
		v[0][0][K]= true;
		q.offer(new Node(0,0,K,0));
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.y==H-1&&cur.x==W-1) {
				System.out.println(cur.d);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + monkeyD[d][0];
				int nx = cur.x + monkeyD[d][1];
				if (!isValid(ny, nx)||map[ny][nx]==1||v[ny][nx][cur.k])
					continue;
				v[ny][nx][cur.k] = true;
				q.offer(new Node(ny,nx,cur.k,cur.d+1));
			}
			if(cur.k==0)continue;
			for (int d = 0; d < 8; d++) {
				int ny = cur.y + horseD[d][0];
				int nx = cur.x + horseD[d][1];
				if (!isValid(ny, nx)||map[ny][nx]==1||v[ny][nx][cur.k-1])
					continue;
				v[ny][nx][cur.k-1] = true;
				q.offer(new Node(ny,nx,cur.k-1,cur.d+1));
			}
			
		}
		System.out.println(-1);
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= H || x >= W)
			return false;
		return true;
	}

	static class Node {
		int y, x, k, d;

		public Node(int y, int x, int k, int d) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}

	}
}

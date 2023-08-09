package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int N, matrix[][];
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			N = Integer.parseInt(br.readLine());
			matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxX = 0;
			int maxY = 0;
			int max = 0;
			for(int i =0;i<N;i++) {
				for(int j= 0;j<N;j++) {
					int sum = bfs(i,j);
					if(sum>=max) {
						if(sum==max&&matrix[i][j]>=matrix[maxY][maxX]) continue;
						maxY = i;
						maxX =j;
						max = sum;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(matrix[maxY][maxX]).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static int bfs(int y, int x) {
		int cnt = 0;
		Queue<Idx> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		q.add(new Idx(y, x));
		v[y][x] = true;
		while(!q.isEmpty()) {
			Idx cur = q.poll();
			cnt++;
			for(int d= 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx= cur.x+dx[d];
				if(!isValid(ny,nx)||v[ny][nx]||matrix[cur.y][cur.x]-matrix[ny][nx]!=-1)continue;
				q.offer(new Idx(ny,nx));
				v[ny][nx] = true;
				break;
			}
		}
		return cnt;
	}

	static class Idx {
		int y;
		int x;

		public Idx(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=N)return false;
		return true;
	}
}

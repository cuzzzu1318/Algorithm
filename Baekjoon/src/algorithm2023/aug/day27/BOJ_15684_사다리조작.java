package algorithm2023.aug.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	static int N, M, H, ladder[][];
	static int min = Integer.MAX_VALUE;

	// 내려가는 경우와 가로선이 존재해서 좌우로 가는 경우
	static int[] dy = { 1, 0, 0 };
	static int[] dx = { 0, 1, -1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[H+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
			ladder[a][b+1] = 2;
		}
		makeLine(1,1,0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
	}
	
	static void makeLine(int c, int r, int cnt) {
		if(cnt>3)return;
		
		if(c==N) {
			makeLine(1,r+1,cnt);
			return;
		}
		if(r==H+1) {
			if(isValid()) {
				for(int i= 1;i<=H;i++) {
					for(int j = 1;j<=N;j++) {
						if(ladder[i][j]==1)System.out.print(j+" "+i+", ");
					}
				}
				System.out.println();
				min = Math.min(min, cnt);
			}
			return;
		}
		
		if(ladder[r][c]==0&&ladder[r][c+1]==0) {
			ladder[r][c]=1;
			ladder[r][c+1]=2;
			makeLine(c+1,r,cnt+1);
			ladder[r][c] = 0;
			ladder[r][c+1]=0;
		}
		makeLine(c+1,r,cnt);
	}
	
	static boolean isValid() {
		boolean ret = true;
		//가로로 탐색
		
//		for(int i = 1;i<=H;i++) {
//			System.out.println(Arrays.toString(ladder[i]));
//		}
		
		for(int i=1 ;i<=N;i++) {
			int x = i;
			int y = 1;
			boolean[][] v = new boolean[H+2][N+1];
			v[y][x] = true;
			while(y<=H) {
				int d = ladder[y][x];
				int ny = y+dy[d];
				int nx = x+dx[d];
				
				if(v[ny][nx]) {
					ny=y+1;
					nx=x;
				}
				x=nx;
				y=ny;
				v[y][x] = true;
			}
			if(x!=i)ret = false;
		}
		return ret;
	}
}

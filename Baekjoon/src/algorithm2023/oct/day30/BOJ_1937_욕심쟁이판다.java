package algorithm2023.oct.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, map[][], dp[][];
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int y, x;


		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
		
	}
	static boolean isValid(int y ,int x) {
		if(y<0||x<0||y>=n||x>=n)return false;
		return true;
	}
	
	
	
	public static void main(String[] args) throws Exception{
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i = 0;i<n;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i =0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max =0;
		
		for(int i =0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(dp[i][j] != -1)continue;
				Queue<Pos> q = new LinkedList<>();
				q.add(new Pos(i,j));
				while(!q.isEmpty()) {
					Pos cur = q.poll();
					dp[cur.y][cur.x]=1;
					for(int d= 0;d<4;d++) {
						int ny = cur.y+dy[d];
						int nx = cur.x+dx[d];
						if(!isValid(ny,nx)||map[ny][nx]<=map[cur.y][cur.x])continue;
						if(dp[ny][nx]!=-1) {
							dp[cur.y][cur.x]+=dp[ny][nx];
						}else {
							q.add(new Pos(ny,nx));
							dp[cur.y][cur.x]++; 
						}
						max = Math.max(max, dp[cur.y][cur.x]);
					}
				}
			}
		}
		print();
		System.out.println(max);
		
	}
	
	static void print() {
		for(int i =0;i<n;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}

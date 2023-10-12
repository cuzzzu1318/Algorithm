package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int M,N,maze[][];
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static class Pos{
		int y,x,d;

		public Pos(int y, int x,int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
		
	}
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=M)return false;
		return true;
		
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		
		for(int i =0 ;i<N;i++) {
			String[] s = br.readLine().split("");
			for(int j =0;j<M;j++) {
				maze[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		PriorityQueue<Pos> pq = new PriorityQueue<>((o1,o2)->o1.d-o2.d);
		pq.add(new Pos(0,0,0));
		
		int[][] dijk = new int[N][M];
		for(int i= 0;i<N;i++) {
			Arrays.fill(dijk[i], Integer.MAX_VALUE);
		}
		
		while(!pq.isEmpty()) {
			Pos cur = pq.poll();
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(!isValid(ny,nx))continue;
				int cost = cur.d;
				if(maze[ny][nx]==1) {
					cost++;
				}
				if(dijk[ny][nx]>cost) {
					dijk[ny][nx] = cost;
					pq.add(new Pos(ny,nx,cost));
				}
			}
		}
		if(N==1&&M==1)dijk[0][0] = 0;
		System.out.println(dijk[N-1][M-1]);
	}
}

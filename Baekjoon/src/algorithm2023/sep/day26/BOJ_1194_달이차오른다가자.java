package algorithm2023.sep.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	
	static int N, M;
	static char[][] maze;
	static Node start;
	
	
	static class Node{
		int y, x, key, d;

		public Node(int y, int x, int key, int d) {
			super();
			this.y = y;
			this.x = x;
			this.key = key;
			this.d = d;
		}

		@Override
		public String toString() {
			return "y=" + y + ", x=" + x + ", key=" + key + ", d=" + d + " "
					+ "val = "+maze[y][x]+ "]\n";
		}
		
		
		
	}
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=M||maze[y][x]=='#')return false;
		return true;
	}
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][];
		
		
		
		for(int i =0 ;i<N;i++) {
			maze[i] = br.readLine().toCharArray();
			for(int j =0;j<M;j++) {
				if(maze[i][j]=='0') {
					start = new Node(i,j,0, 0);
				}
			}
		}
		
		boolean[][][] v = new boolean[N][M][(int) Math.pow(2, 6)+1];
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(start);
		v[start.y][start.x][0]=true;
		
		int key = 0;
		
		int ans = 0;
		
		loop:
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int d = 0;d<4;d++) {
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(!isValid(ny,nx)) continue;
				if(maze[ny][nx]=='1') {
					ans = cur.d+1;
					break loop;
				}
				
				//대문자 ABCDEF -> 문
				if(maze[ny][nx]>=65&&maze[ny][nx]<=70) {
					int sft = 1<<(maze[ny][nx]-'A');
					if(v[ny][nx][cur.key|sft]) {
						continue;
					}
					if((cur.key &sft )>0) {
						v[ny][nx][cur.key|sft]= true;
						q.add(new Node(ny,nx,cur.key|sft, cur.d+1));
					}
//					소문자 abcdef -> 열쇠
				}else if(maze[ny][nx]>=97&&maze[ny][nx]<=102) {

					int sft = 1<<(maze[ny][nx]-'a');
					if(v[ny][nx][cur.key|sft])continue;
					v[ny][nx][cur.key|sft]= true;
					q.add(new Node(ny,nx,cur.key|sft, cur.d+1));
				}else {
					if(v[ny][nx][cur.key])continue;
					v[ny][nx][cur.key]= true;
					q.add(new Node(ny,nx,cur.key,cur.d+1));
				}
			}
		}
		
		System.out.println(ans==0?"-1":ans);
		
		
	}
}

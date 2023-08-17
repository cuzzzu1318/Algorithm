package algorithm2023.aug.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static int H, W, N;
	static char[][] map;
	static char[] func;
	static Tank tank;
	
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t= 1;t<=T;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i = 0;i<H;i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
				for(int j= 0;j<W;j++) {
					switch(map[i][j]) {
					case '^':
						tank= new Tank(i,j,0);
						break;
					case '>':
						tank= new Tank(i,j,1);
						break;
					case 'v':
						tank= new Tank(i,j,2);
						break;
					case '<':
						tank= new Tank(i,j,3);
						break;
						
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			func = br.readLine().toCharArray();
			for(char c : func) {
				process(c);
			}
			sb.append("#").append(t).append(" ");
			for(int i= 0;i<H;i++) {
				for(int j= 0;j<W;j++) {
				sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void process(char c) {
		int ny = tank.y;
		int nx = tank.x;
		switch(c) {
		case 'U':
			map[tank.y][tank.x]= '^'; 
			tank.d = 0;
			ny = tank.y+dy[tank.d];
			nx = tank.x+dx[tank.d];
			if(isField(ny,nx)) {
				map[tank.y][tank.x] = '.';
				map[ny][nx] = '^';
				tank.y = ny;
				tank.x = nx;
			}
			
			break;
		case 'D':
			map[tank.y][tank.x]= 'v'; 
			tank.d = 2;
			ny = tank.y+dy[tank.d];
			nx = tank.x+dx[tank.d];
			if(isField(ny,nx)) {
				map[tank.y][tank.x] = '.';
				map[ny][nx] = 'v';
				tank.y = ny;
				tank.x = nx;
			}
			
			break;
		case 'L':
			map[tank.y][tank.x]= '<'; 
			tank.d = 3;
			ny = tank.y+dy[tank.d];
			nx = tank.x+dx[tank.d];
			if(isField(ny,nx)) {
				map[tank.y][tank.x] = '.';
				map[ny][nx] = '<';
				tank.y = ny;
				tank.x = nx;
			}
			
			break;
		case 'R':
			map[tank.y][tank.x]= '>'; 
			tank.d = 1;
			ny = tank.y+dy[tank.d];
			nx = tank.x+dx[tank.d];
			if(isField(ny,nx)) {
				map[tank.y][tank.x] = '.';
				map[ny][nx] = '>';
				tank.y = ny;
				tank.x = nx;
			}
			
			break;
		case 'S':
			while(true) {
				
				ny +=dy[tank.d];
				nx +=dx[tank.d];
				if(ny<0||nx<0||ny>=H||nx>=W)break;
				if(map[ny][nx]=='*') {
					map[ny][nx] = '.';
					break;
				}
				if(map[ny][nx] == '#')break;
			}
		}
	}
	
	static boolean isField(int y, int x) {
		if(y<0||x<0||y>=H||x>=W||map[y][x]!='.')return false;
		return true;
	}
	
	static class Idx{
		int y;
		int x;
		public Idx(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	static class Tank extends Idx{
		int d;
		public Tank(int y, int x, int d) {
			super(y,x);
			this.d = d;
		}
		@Override
		public String toString() {
			return "Tank [d=" + d + "]";
		}
		
	}
}

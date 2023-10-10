package algorithm2023.oct.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	//R*C 방, T시간 이후의 상태
	static int R, C, T, map[][], temp[][];
	static int[] ac = new int[2];
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	
	static class Idx{
		int y, x, amount;

		public Idx(int y, int x, int amount) {
			super();
			this.y = y;
			this.x = x;
			this.amount = amount;
			
		}

		@Override
		public String toString() {
			return "Idx [y=" + y + ", x=" + x + "]";
		}
		
		
	}
	
	static boolean isValid(int y, int x) {
		if(x<0||y<0||y>=R||x>=C)return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		temp = new int[R][C];
		
		//맵에 값 입력
		for(int i =0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j= 0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) { 
					ac[0] = i;
					ac[1] = j;
				}
			}
		}
		
		for(int t =0;t<T;t++) {
			spread();
			ac();
		}
		
		System.out.println(count());
	}
	
	static void spread() {
		for(int i = 0;i<R;i++) {
			temp[i] = map[i].clone();
		}
		for(int y = 0;y<R;y++) {
			for(int x =0 ;x<C;x++) {
				if(map[y][x] >0) {
					int cnt = 0;
					for(int d= 0;d<4;d++) {
						int ny = y+dy[d];
						int nx = x+dx[d];
						if(!isValid(ny,nx)||map[ny][nx]==-1)continue;
						temp[ny][nx] += map[y][x]/5;
						cnt++;
					}
					temp[y][x] -=(map[y][x]/5)*cnt;
				}
			}
		}
		for(int i = 0;i<R;i++) {
			map[i] = temp[i].clone();
		}
		
	}
	
	static void ac() {
		//공기청정기 위쪽
		int y = ac[0]-2;
		int x = ac[1];
		int d = 0;
		
		int ny = y;
		int nx = x;
		while(map[y][x]!=-1) {
			ny=y+dy[d];
			nx=x+dx[d];
			if(!isValid(ny,nx)||ny==ac[0]){
				d= (d+1)%4;
				ny=y+dy[d];
				nx = x+dx[d];
			}
			if(map[ny][nx]==-1) {
				map[y][x]=0;
				break;
			}
			map[y][x] = map[ny][nx];
			
			y =ny;
			x=nx;
		}
		
		
		//공기청정기 아래쪽
		y = ac[0]+1;
		x = ac[1];
		d = 2;
		
		ny = y;
		nx = x;
		while(map[y][x]!=-1) {
			ny=y+dy[d];
			nx=x+dx[d];
			if(!isValid(ny,nx)||ny==ac[0]-1){
				d--;
				if(d<0)d=3;
				ny=y+dy[d];
				nx = x+dx[d];
			}
			if(map[ny][nx]==-1) {
				map[y][x]=0;
				break;
			}
			map[y][x] = map[ny][nx];
			
			y =ny;
			x=nx;
		}
	}
	
	static int count() {
		int cnt = 0 ;
		for(int i =0 ;i<R;i++) {
			for(int j =0;j<C;j++) {
				if(map[i][j]>0)cnt+=map[i][j];
			}
		}
		return cnt;
	}
	
	static void print() {
		for(int i =0 ;i<R;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}
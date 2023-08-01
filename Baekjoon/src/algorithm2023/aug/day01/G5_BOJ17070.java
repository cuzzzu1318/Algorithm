package algorithm2023.aug.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_BOJ17070 {
	static int N, COUNT, house[][];
	static int[] dy = {0,1,1};
	static int[] dx = {1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		//집과 방문배열
		house = new int[N][N];
		
		//입력
		for(int i = 0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j= 0;j<N;j++) {
				house[i][j] = Integer.parseInt(s[j]);
			}
		}
		canGo(0,1,0);
		System.out.println(COUNT);
	}
	
	static void canGo(int y, int x, int d) {
		//목적지에 도달하면 true;
		if(y==N-1&&x==N-1) {
			COUNT++;
		}else {
			boolean isEmp = true;
			switch(d) {
			case 0:
				for(int i=0;i<3;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					if(isValid(ny,nx)&&house[ny][nx]==0) {
						if(i==0) {
							canGo(ny,nx,i);
						}
						
					}else {
						isEmp = false;
					}
				}
				if(isEmp) {
					canGo(y+dy[1], x+dx[1], 1);
				}
				break;
			case 1:
				for(int i=0;i<3;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					if(isValid(ny,nx)&&house[ny][nx]==0) {
						if(i==0) {
							canGo(ny,nx,i);
						}
						if(i==2) {
							canGo(ny,nx,i);
						}
						
					}else {
						isEmp = false;
					}
				}
				if(isEmp) {
					canGo(y+dy[1], x+dx[1], 1);
				}
				break;
			case 2:
				for(int i=0;i<3;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					if(isValid(ny,nx)&&house[ny][nx]==0) {
						if(i==2) {
							canGo(ny,nx,i);
						}
						
					}else {
						isEmp = false;
					}
				}
				if(isEmp) {
					canGo(y+dy[1], x+dx[1], 1);
				}
				break;
				
			}
		}
	}
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=N)return false;
		return true;
	}
	
}

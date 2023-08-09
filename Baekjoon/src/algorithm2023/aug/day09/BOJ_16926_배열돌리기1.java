package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	static int N,M,R, arr[][];
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr =new int[N][M];
		R = Integer.parseInt(st.nextToken());
		for(int i= 0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0;i<R;i++) {
			for(int j = 0;j<Math.min(N, M)/2;j++) {
				rotate(j);
			}
		}
		print();
		
	}
	
	static void print() {
		for(int i= 0;i<N;i++) {
			for(int j= 0;j<M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void rotate(int i) {
		int d = 0;
		int start = arr[i][i];
		int prevY = i;
		int prevX = i;
		int y = i;
		int x= i+1;
		while(true) {
			arr[prevY][prevX] = arr[y][x];
			if(!isValid(y+dy[d],x+dx[d],i)) d++;
			if(d==4)break;
			prevY = y;
			prevX = x;
			y +=dy[d];
			x+=dx[d];
		}
		arr[i+1][i] = start;
		
	}
	
	static boolean isValid(int y, int x, int i) {
		if(x<i||y<i||y>=N-i||x>=M-i)return false;
		return true;
	}
}

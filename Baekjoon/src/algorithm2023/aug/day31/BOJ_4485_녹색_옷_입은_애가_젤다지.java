package algorithm2023.aug.day31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	static int N, cave[][];
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=N||x>=N)return false;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		while((input=Integer.parseInt(br.readLine()))!=0) {
			N = input;
			cave = new int[N][N];
			for(int i =0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j= 0;j<N;j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
		
	}
	
	static int dijkstra() {
		int[][] dijk = new int[N][N];
		
	}
}

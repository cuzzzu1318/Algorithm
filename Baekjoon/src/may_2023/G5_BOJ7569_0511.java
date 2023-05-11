package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_BOJ7569_0511 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {-1,0,1,0};
	static int[] dz = {0,1,0,-1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] tomato = new int[H+2][N+2][M+2];
		for(int i = 0;i<H+2;i++) {
			for(int j = 0;j<N+2;j++) {
				Arrays.fill(tomato[i][j], -1);
			}
		}
		
		for(int h = 1;h<=H;h++) {
			for(int n = 1;n<=N;n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int m = 1;m<=M;m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
	}
}
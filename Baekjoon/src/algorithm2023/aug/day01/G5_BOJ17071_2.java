package algorithm2023.aug.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_BOJ17071_2 {
	static int N, COUNT, house[][], dp[][][];
	static int[] dy = { 0, 1, 1 };
	static int[] dx = { 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 집과 방문배열
		house = new int[N][N];
		dp = new int[N][N][3];
		// 입력
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(s[j]);
			}
		}
		dp[0][1][0] = 1;
		for(int y= 0;y<N;y++) {
			for(int x = 2;x<N;x++) {
				if(house[y][x]==1) continue;
				dp[y][x][0] = dp[y][x-1][0]+dp[y][x-1][1];
				if(y>0) {
					if(house[y-1][x]!=1&&house[y][x-1]!=1) {
						dp[y][x][1] = dp[y-1][x-1][0]+dp[y-1][x-1][1]+dp[y-1][x-1][2];
					}
						dp[y][x][2] = dp[y-1][x][1] + dp[y-1][x][2];
				}
				
				
			}
		}
		
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}

	static boolean isValid(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N||house[y][x]==1)
			return false;
		return true;
	}

}



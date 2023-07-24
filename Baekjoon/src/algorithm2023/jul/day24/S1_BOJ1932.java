package algorithm2023.jul.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1_BOJ1932 {

	static int N, triangle[][], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				triangle[i][j] = Integer.parseInt(s[j]);
			}
		}
		dp[0][0] = triangle[0][0];
		dp();
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[N - 1][i]);
		}
		System.out.println(max);
	}

	static void dp() {
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
				}
			}
		}
	}

}

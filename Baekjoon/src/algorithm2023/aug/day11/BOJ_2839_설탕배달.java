package algorithm2023.aug.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2839_설탕배달 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		Arrays.fill(dp, 5000);
		dp[3] = 1;
		dp[5] = 1;
		for(int i =6;i<=N;i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i]);
			dp[i] = Math.min(dp[i-5]+1, dp[i]);
		}
		System.out.println(dp[N]==5000?-1:dp[N]);

	}
}

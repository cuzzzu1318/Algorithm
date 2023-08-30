package algorithm2023.aug.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	static int N, M;
	static long dp[][];

	static StringBuilder sb =  new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dp = new long[M + 1][N + 1];

			sb.append(dp(M, N)).append("\n");
		}
		System.out.println(sb);
	}

	static long dp(int m, int n) {
		if (m < n)
			return 0;
		if (n == 1)
			return m;

		if (dp[m][n] > 0)
			return dp[m][n];

		return dp[m][n] = dp(m - 1, n - 1) + dp(m - 1, n);

	}

}

package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463_1로만들기 {
	static int N, dp[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		Arrays.fill(dp, 1000000);
		dp[1] = 0;
		for(int i =1;i<N;i++) {
			if(i*3<=N) {
				dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
			}
			if(i*2<=N) {
				dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
			}
			dp[i+1] = Math.min(dp[i]+1, dp[i+1]);
		}
		
		System.out.println(dp[N]);
		
	}
}

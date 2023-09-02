package algorithm2023.sep.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17626_FourSquares {
	static int n, dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[50001];
		
		dp[1] = 1;
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 1;i<=Math.sqrt(50000);i++) {
			
		}
		
	}
	
}

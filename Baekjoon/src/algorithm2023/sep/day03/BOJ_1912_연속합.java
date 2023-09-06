package algorithm2023.sep.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {
	static int n, arr[], dp[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		for(int i = 1;i<n;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
		
	}
}

package algorithm2023.sep.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055_가큰증부수 {
	static int N, arr[], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = arr.clone();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for(int j= 0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);

	}
}

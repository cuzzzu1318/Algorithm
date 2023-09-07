package algorithm2023.sep.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 자연수 정수 N과 K가 주어졌을 때 이항계수 (N,K)를 10_007로 나눈 나머지 구하기
 * nCk = n-1Ck + n-1Ck-1임을 이용해서 dp로 풀이
 */

public class BOJ_11051_이항계수2 {
	static int N, K, dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		System.out.println(bino_coef(N,K));
		
	}
	
	static int bino_coef(int n, int k) {
		if(k>n)return 0;
		if(n==k||k==0) return 1;
		if(dp[n][k]>0)return dp[n][k];
		
		return dp[n][k] = (bino_coef(n-1,k)+bino_coef(n-1,k-1))%10007;
	}
	
}

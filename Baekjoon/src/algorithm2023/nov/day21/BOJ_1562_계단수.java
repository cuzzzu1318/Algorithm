package algorithm2023.nov.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1562_계단수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, dp[][][];
	static int mask = 1023;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		dp = new int[mask+1][N+1][10];
		
		if(N<10)System.out.println(0);
		else {
			int cnt = 0;
			for(int i =1 ;i<10;i++) {
				cnt= (cnt+getAns(mask, N, i))%1_000_000_000;
			}
			System.out.println(cnt);
		}
		
	}
	
	static int getAns(int bit,int len,int n) {
		System.out.println(Integer.toBinaryString(bit)+" "+len+" "+n);
		if(n>9||n<0||len<0)return 0;
		if(len==0) {
			if(bit==0)return 1;
			else return 0;
		}
		if(dp[bit][len][n]!=0)return dp[bit][len][n];
		dp[bit][len][n] = (dp[bit][len][n] + getAns(bit, len-1, n+1))%1_000_000_000;
		dp[bit][len][n] = (dp[bit][len][n] + getAns(bit, len-1, n-1))%1_000_000_000;
		
		int nextB = bit&~(1<<n);
		if(bit!=nextB) {
			dp[bit][len][n] = (dp[bit][len][n] + getAns(nextB, len-1, n-1))%1_000_000_000;			
			dp[bit][len][n] = (dp[bit][len][n] + getAns(nextB, len-1, n+1))%1_000_000_000;			
		}
		
		
		return dp[bit][len][n];
	}
}

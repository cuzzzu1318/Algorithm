package algorithm2023.aug.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	static int N,L, ingre[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N =Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ingre = new int[N][2];
			int[] dp = new int[L+1];
			for(int i = 0;i<N;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ingre[i][0] = Integer.parseInt(st.nextToken());
				ingre[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i= 0;i<N;i++) {
				int cal = ingre[i][1];
				int score = ingre[i][0];
				for(int j= L;j>=cal;j--) {
					dp[j] = Math.max(dp[j], dp[j-cal]+score);
				}
			}
			sb.append("#").append(t).append(" ").append(dp[L]).append("\n");
		}
		System.out.println(sb);
	}
}

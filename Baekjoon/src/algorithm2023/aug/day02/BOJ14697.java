package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14697 {
	static int N;
	static int[] room = new int[3];
	static boolean dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;i<3;i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(st.nextToken());
		dp = new boolean[N+1];
		dp[0] = true;
		for(int i =0;i<3;i++) {
			for(int j = room[i] ;j<=N;j++) {
				if(dp[j-room[i]]) {
					dp[j] = true;
				}
			}
		}
		System.out.println(dp[N]?1:0);
		
	}
}

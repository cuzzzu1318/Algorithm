package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_BOJ2839_0426 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[5001];
		Arrays.fill(dp, 2000);
		
		dp[3] = 1;
		dp[5] = 1;
		//3킬로그램과 5킬로그램인 경우 초기화
		
		for(int i = 6;i<N+1;i++) {
			//dp 
			int min = dp[i];
			min = Math.min(dp[i-3]+1, min);
			min = Math.min(dp[i-5]+1, min);
			dp[i] = min;
		}
		if(dp[N]==2000) {
			//2000이 그대로 있는 경우 -> 5와 3으로 만들 수 없음 -> -1 출력
			dp[N] = -1;
		}
		bw.write(Integer.toString(dp[N]));
		
		
		bw.flush();
		bw.close();
	}

}
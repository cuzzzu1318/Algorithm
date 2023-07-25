package algorithm2023.jul.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1_BOJ1932 {

	static int N, triangle[][], dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		triangle = new int[N][N];
		dp = new int[N][N];
		//입력
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < s.length; j++) {
				triangle[i][j] = Integer.parseInt(s[j]);
			}
		}
		//0,0에서의 최댓값은 자기 자신
		dp[0][0] = triangle[0][0];
		//dp시행
		dp();
		int max = 0;
		//맨 마지막 줄의 값들 중 최댓값 출력
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[N - 1][i]);
		}
		System.out.println(max);
	}

	static void dp() {
		//0번째는 기록했으니 1번째줄부터 시작
		for (int i = 1; i < N; i++) {
			//각 줄의 원소 개수는 i+1개이므로 그만큼 탐색
			for (int j = 0; j < i + 1; j++) {
				//왼쪽, 오른쪽, 중간으로 나누어서 dp 시행
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
				}
			}
		}
	}

}

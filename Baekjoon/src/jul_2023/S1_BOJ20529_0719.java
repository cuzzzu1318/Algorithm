package jul_2023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_BOJ20529_0719 {
	static int min = 0;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			min = 100000000;
			int N = Integer.parseInt(br.readLine());

			String[] mbti = br.readLine().split(" ");
			if (N > 32) {
				min = 0;
			} else {
				Integer[][] dist = new Integer[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = i + 1; j < N; j++) {
						for (int k = j + 1; k < N; k++) {
							int sum = cntDiff(mbti, i, j, dist) + cntDiff(mbti, j, k, dist) + cntDiff(mbti, k, i, dist);
							min = Math.min(min, sum);
						}
					}
				}
			}

			System.out.println(min);
		}

	}

	static int cntDiff(String[] mbti, int a, int b, Integer[][] dist) {
		if (dist[a][b] != null) {
			return dist[a][b];
		}
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (mbti[a].charAt(i) != mbti[b].charAt(i)) {
				cnt++;
			}
		}
		dist[a][b] = cnt;
		dist[b][a] = cnt;
		return cnt;
	}

}

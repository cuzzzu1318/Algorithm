package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int N, synergy[][];
	static boolean[] select;
	static int min;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			select = new boolean[N];
			synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);

	}

	static void comb(int idx, int cnt) {
		if (cnt == N / 2) {
			min = Math.min(min, calc());
		}
		if (idx >= N)
			return;
		select[idx] = true;
		comb(idx + 1, cnt + 1);
		select[idx] = false;
		comb(idx + 1, cnt);

	}

	static int calc() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (select[i] && select[j]) {
					sum1 += synergy[i][j];
				}
				if (!select[i] && !select[j]) {
					sum2 += synergy[i][j];
				}
			}
		}
		return Math.abs(sum1 - sum2);

	}
}

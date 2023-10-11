package algorithm2023.oct.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11401_이항계수3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, R;
	static final int P = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		long ans = 1;
		// N!
		for (int i = 2; i <= N; i++) {
			ans = ans * i % P;
		}

		// (N-R)!R!의 역원 구하기 (N-R)!R!의 P-2승

		long inverse = 1;
		for (int i = 2; i <= N - R; i++) {
			inverse = inverse * i % P;
		}
		for (int i = 2; i <= R; i++) {
			inverse = inverse * i % P;
		}

		int k = P - 2;
		while (k > 0) {
			if ((k & 1) == 1) {
				ans = ans * inverse % P;
			}
			k /= 2;
			inverse = inverse * inverse % P;
		}

		sb.append(ans);

		System.out.println(sb);

	}
}

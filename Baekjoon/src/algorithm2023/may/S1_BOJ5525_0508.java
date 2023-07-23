package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_BOJ5525_0508 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int cnt = 0;
		int ans = 0;
		for (int i = 1; i < M - 1; i++) {
			if (s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
				cnt++;
				if (cnt == N) {
					if (s.charAt(i - 2 * N + 1) == 'I') {
						ans++;
					}
					cnt--;
				}
				i++;
			} else {
				cnt = 0;
			}

		}
		System.out.println(ans);

	}
}
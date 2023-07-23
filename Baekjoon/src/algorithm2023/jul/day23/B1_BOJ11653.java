package algorithm2023.jul.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1_BOJ11653 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 2; i <= N; i++) {
			while (N % i == 0) {
				N /= i;
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}

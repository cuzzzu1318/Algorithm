package algorithm2023.aug.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	static int[] prime = {2, 3, 5, 7 };
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i =0; i < 4; i++) {
			comb(1,prime[i]);
		}
		System.out.println(sb);
	}

	static void comb(int tIdx, int n) {
		if (tIdx == N) {
			sb.append(n).append("\n");
			return;
		}
		for (int i = 1; i < 10; i+=2) {
			if(isPrime(n*10+i)) {
				comb(tIdx + 1, n*10+i);
			}
			
		}

	}

	static boolean isPrime(int n) {
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}
}

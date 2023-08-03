package algorithm2023.aug.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	static int[] prime = { 1, 2, 3, 5, 7 };
	static boolean[] isPrime;
	static int N;
	static boolean[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		selected = new boolean[N];
		isPrime = new boolean[(int) Math.pow(10, N - 1)];
		for (int i = 2; i < isPrime.length; i++) {
			for (int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static void comb(int sIdx, int tIdx) {

	}
}

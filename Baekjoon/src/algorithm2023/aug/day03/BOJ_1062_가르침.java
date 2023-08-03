package algorithm2023.aug.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1062_가르침 {
	static int N, K, max;
	static boolean[] selected;
	static String[] word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		selected = new boolean[N];
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
	}
}

package algorithm2023.oct.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1786_찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static char[] T, P;
	static int pi[];
	static ArrayList<Integer> ans = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();

		pi = new int[P.length];

		int j = 0;

		//pi배열 만들기
		for (int i = 1; i < P.length; i++) {
			while (j > 0 && P[i] != P[j])
				j = pi[j - 1];
			if (P[i] == P[j])
				pi[i] = ++j;
		}

		j = 0;

		
		//실제 문자열 탐색
		for (int i = 0; i < T.length; i++) {

			while(j>0&&T[i]!=P[j]) {
				j = pi[j-1];
			}
			
			if(T[i]==P[j]) {
				if(++j==P.length) {
					ans.add(i-P.length+2);
					j = pi[j-1];
				}
			}
			
		}
		sb.append(ans.size()).append("\n");
		for(int n : ans) {
			sb.append(n+" ");
		}
		System.out.println(sb);

	}
}

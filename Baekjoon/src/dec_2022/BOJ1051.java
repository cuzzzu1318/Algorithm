package dec_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1051 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		ArrayList<ArrayList<Integer>> sq = new ArrayList<>();
		int N = Integer.parseInt(s[0]);
		int l = N - 1;
		int M = Integer.parseInt(s[1]);
		if (M < N) {
			l = M - 1;
		}
		for (int i = 0; i < N; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			s = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr.add(Integer.parseInt(s[j]));
			}
			sq.add(arr);
		}
		//System.out.println(l);
		int edge;
		Loop1: while (l >= 0) {
			for (int j = 0; j < M - l; j++) {
				for (int i = 0; i < N - l; i++) {
					//System.out.println((i+l)+" "+(j+l));
					if (sq.get(i).get(j) == sq.get(i + l).get(j) && sq.get(i).get(j) == sq.get(i).get(j + l)
							&& sq.get(i).get(j) == sq.get(i + l).get(j + l)) {
						System.out.println((l+1)*(l+1));
						break Loop1;
					}
					
				}
			}
			l--;
		}

	
	}
}
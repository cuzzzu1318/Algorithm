package nov_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA6190 {

	public static boolean isMono(long a, long b) {
		ArrayList<Long> check = new ArrayList<>();
		long n = a * b;
		if(n==0) {
			return false;
		}
		while (n > 0) {
			check.add(n % 10);
			n /= 10;
		}
		boolean bool = true;
		for (int i = 0; i < check.size() - 1; i++) {
			if (check.get(i) < check.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			ArrayList<Long> Aarr = new ArrayList<>();
			ArrayList<Long> ans = new ArrayList<>();
			for (String s : str) {
				Aarr.add(Long.parseLong(s));
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (isMono(Aarr.get(i), Aarr.get(j))) {
						ans.add(Aarr.get(i) * Aarr.get(j));
					}
				}
			}
			Collections.sort(ans);
			if (ans.size() == 0) {
				System.out.println("#" + t + " " + (-1));
			} else {

				System.out.println("#" + t + " " + ans.get(ans.size() - 1));
			}

		}
	}
}
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

public class SWEA2817 {

	static int dp(ArrayList<Integer> arr, int i, int K) {

		return 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			int cnt = 0;
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<ArrayList<Integer>> d = new ArrayList<>();
			for (String item : br.readLine().split(" ")) {
				ArrayList<Integer> a = new ArrayList<>();
				arr.add(Integer.parseInt(item));
				a.add(Integer.parseInt(item));
				d.add(a);
			}
			for (int i = 0; i < N; i++) {
				if (arr.get(i) == K) {
					cnt++;
					continue;
				}
				for (int j = 0; j < i; j++) {
					for (int item : d.get(j)) {
						int sum = item + arr.get(i);
						if (sum == K) {
							cnt++;
						} else {
							d.get(i).add(sum);
						}
					}
				}

			}
			System.out.println("#" + (t + 1) + " " + cnt);

		}
	}
}
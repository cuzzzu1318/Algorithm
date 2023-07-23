package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1240 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] enc = { 
					{ 0, 0, 0, 1, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 0, 1 },
					{ 0, 0, 1, 0, 0, 1, 1 },
					{ 0, 1, 1, 1, 1, 0, 1 },
					{ 0, 1, 0, 0, 0, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 1 },
					{ 0, 1, 0, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0, 1, 1 },
					{ 0, 1, 1, 0, 1, 1, 1 }, 
					{ 0, 0, 0, 1, 0, 1, 1 } };

			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				s = br.readLine().split("");
				int n = 0;
				for (int j = s.length - 1; j >= 0; j--) {
					if (s[j].equals("1")) {
						n = j;
						ArrayList<Integer> a = new ArrayList<>();
						for (int k = n - 55; k <= n; k++) {
							a.add(Integer.parseInt(s[k]));
						}
						arr.add(a);
						break;
					}
				}
			}
			int[] ans = new int[8];
			for (int i = 0; i < 56; i += 7) {
				for (int j = 0; j <= 9; j++) {
					int n = j;
					for (int k = 0; k < 7; k++) {
						if (arr.get(0).get(i + k) != enc[j][k]) {
							n = -1;
						}
					}
					if (n != -1) {
						ans[i / 7] = n;
					}
				}
			}
			
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0;i<8;i++) {
				if(i%2==0) {
					sum1+=ans[i];
				}else {
					sum2+=ans[i];
				}
			}
			int sum3 = (sum1*3)+sum2;
			if(sum3%10==0) {
				System.out.println("#"+t+" "+(sum1+sum2));
			}else {
				System.out.println("#" + t+" "+0);
			}

		}
	}
}
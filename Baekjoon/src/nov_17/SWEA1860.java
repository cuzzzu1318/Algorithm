package nov_17;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SWEA1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			ArrayList<Integer> arrive = new ArrayList<>();
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int K = Integer.parseInt(str[2]);
			str = br.readLine().split(" ");
			int[] arr = new int[11112];
			for (int i = 0; i < 11112; i++) {
				arr[i] = K * (i / M);
			}

			String isPossible = "Possible";
			for (String s : str) {
				int man = Integer.parseInt(s);
				if (arr[man] == 0) {
					isPossible = "Impossible";
					break;
				} else {
					for (int j = man - (man % M); j < 11112; j++) {
						arr[j] -= 1;
					}
				}
				/*for (int i = 0; i < 10; i++) {
					System.out.print(arr[i]);
				}
				System.out.println("");*/
			}
			System.out.println("#"+t+" "+isPossible);

		}
	}
}
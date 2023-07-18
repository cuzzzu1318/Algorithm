package nov_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class SWEA1954 {

	static void snail(int[][] arr) {

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<int[][]> ansArr = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int[] a : arr) {
				Arrays.fill(a, 0);
			}
			int swtch = 0;
			int idx1 = 0;
			int idx2 = 0;
			int maxWid = N;
			int minWid = 0;
			int maxHeight = N;
			int minHeight = 0;
			int num = 1;
			while (num < N * N + 1) {
				arr[idx1][idx2] = num++;
				;
				if (swtch == 0) {
					idx2 += 1;
					if (idx2 >= maxWid) {
						swtch = 1;
						idx2 -= 1;
						idx1 += 1;
						minHeight++;
					}
				} else if (swtch == 1) {
					idx1 += 1;
					if (idx1 >= maxHeight) {
						swtch = 2;
						idx1 -= 1;
						idx2 -= 1;
						maxWid--;
					}
				} else if (swtch == 2) {
					idx2 -= 1;
					if (idx2 < minWid) {
						swtch = 3;
						idx2 += 1;
						idx1 -= 1;
						maxHeight--;
					}
				} else if (swtch == 3) {
					idx1 -= 1;
					if (idx1 < minHeight) {
						swtch = 0;
						idx1 += 1;
						idx2 += 1;
						minWid++;
					}
				}
			}

			ansArr.add(arr);
		}
		int cnt = 1;
		for (int[][] itemArr : ansArr) {
			System.out.println("#" + cnt++);
			for (int[] item : itemArr) {
				for (int it : item) {
					System.out.print(it + " ");
				}
				System.out.println("");
			}
		}
	}
}
package jan_2022;

/* �������� �־����� ���ڸ� �ҷ���.
 * ���° ���ڸ� �ҷ��� ���� 3���� �ϼ����� ���
 * ���̵� : �ǹ� 4
 * ���̵��: �� ������..
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2578 {

	static boolean isBingo(boolean[][] fill) {
		int[] wid = new int[5];
		int[] len = new int[5];
		int[] dig = new int[2];
		Arrays.fill(wid, 0);
		Arrays.fill(len, 0);
		Arrays.fill(dig, 0);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (fill[i][j]) {
					wid[i]++;
					len[j]++;
					if (i == j) {
						dig[0]++;
					}
					if ((i + j) == 4) {
						dig[1]++;
					}
				}
			}
		}
		int cnt = 0;
		for (int n : wid) {
			if (n == 5) {
				cnt++;
			}
		}
		for (int n : len) {
			if (n == 5) {
				cnt++;
			}
		}
		for (int n : dig) {
			if (n == 5) {
				cnt++;
			}
		}
		if (cnt >= 3) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(s[j]);
			}
		}

		boolean[][] fill = new boolean[5][5];
		loop: for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(s[j]);
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (bingo[k][l] == n) {
							fill[k][l] = true;
							if (isBingo(fill)) {
								System.out.println((i * 5) + j + 1);
								break loop;
							}
						}
					}
				}
			}
		}

	}
}
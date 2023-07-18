package jan_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18111 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int B = Integer.parseInt(s[2]);
		int[][] floor = new int[N][M];

		int max = 0;
		int min = 256;

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				floor[i][j] = Integer.parseInt(s[j]);
				if (max < floor[i][j]) {
					max = floor[i][j];
				}
				if (min > floor[i][j]) {
					min = floor[i][j];
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		int h = 0;
		loop: for (int i = min; i <= max; i++) {
			int block = B;
			int time = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (floor[j][k] > i) {
						time += (floor[j][k] - i) * 2;
						block += (floor[j][k] - i);
					} else if (floor[j][k] < i) {
						time += (i - floor[j][k]);
						block -= (i - floor[j][k]);
					}
				}
			}
			if(block<0) {
				continue loop;
			}
			if (ans > time) {
				ans = time;
				h = i;
			} else if (ans == time) {
				if (h < i) {
					h = i;
				}
			}
		}
		System.out.println(ans + " " + h);

	}
}
package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	static int N, r, c, cnt;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int l = (int) Math.pow(2, N);
		Z(0, 0, l);
	}

	static void Z(int y, int x, int l) {
		if (flag)
			return;
		if (l == 1) {
			if (y == r && x == c) {
				System.out.println(cnt);
				flag = true;
			}
			cnt++;

			return;
		}
		if (r < y+l/2) {
			if (c < x+l/2) {
				Z(y, x, l / 2);
			} else {
				cnt += l * l / 4;
				Z(y, x + l / 2, l / 2);
			}
		} else {
			if (c < x+l/2) {
				cnt += l * l / 2;
				Z(y + l / 2, x, l / 2);
			} else {
				cnt += l * l / 4 * 3;
				Z(y + l / 2, x + l / 2, l / 2);
			}
		}

	}

}

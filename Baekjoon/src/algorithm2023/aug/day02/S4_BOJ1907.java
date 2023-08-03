package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_BOJ1907 {
	static String M1, M2, M3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "+=");
		M1 = st.nextToken();
		M2 = st.nextToken();
		M3 = st.nextToken();
		loop: for (int X1 = 1; X1 <= 10; X1++) {
			for (int X2 = 1; X2 <= 10; X2++) {
				for (int X3 = 1; X3 <= 10; X3++) {
					if (isValid(X1, X2, X3)) {
						System.out.println(X1 + " " + X2 + " " + X3);
						break loop;
					}
				}
			}
		}

	}

	static boolean isValid(int X1, int X2, int X3) {
		int C = 0;
		int H = 0;
		int O = 0;
		int n = 1;
		for (int i = M1.length() - 1; i >= 0; i--) {
			switch (M1.charAt(i)) {
			case 'C':
				C += X1 * n;
				n = 1;
				break;
			case 'O':
				O += X1 * n;
				n = 1;
				break;
			case 'H':
				H += X1 * n;
				n = 1;
				break;
			default:
				n = M1.charAt(i) - '0';
			}
		}

		for (int i = M2.length() - 1; i >= 0; i--) {
			switch (M2.charAt(i)) {
			case 'C':
				C += X2 * n;
				n = 1;
				break;
			case 'O':
				O += X2 * n;
				n = 1;
				break;
			case 'H':
				H += X2 * n;
				n = 1;
				break;
			default:
				n = M2.charAt(i) - '0';
			}

		}
		for (int i = M3.length() - 1; i >= 0; i--) {
			switch (M3.charAt(i)) {
			case 'C':
				C -= X3 * n;
				n = 1;
				break;
			case 'O':
				O -= X3 * n;
				n = 1;
				break;
			case 'H':
				H -= X3 * n;
				n = 1;
				break;
			default:
				n = M3.charAt(i) - '0';
			}
		}
		if (C == 0 && H == 0 && O == 0) {
			return true;
		}
		return false;
	}

}

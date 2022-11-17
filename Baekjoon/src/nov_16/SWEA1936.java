package nov_16;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1936 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);

		if (A == 1) {
			if (B == 2) {
				System.out.println("B");
			}
			if (B == 3) {
				System.out.println("A");
			}
		}
		if (A == 2) {
			if (B == 1) {
				System.out.println("A");
			}
			if (B == 3) {
				System.out.println("B");
			}
		}
		if (A == 3) {
			if (B == 1) {
				System.out.println("B");
			}
			if (B == 2) {
				System.out.println("A");
			}
		}
	}
}
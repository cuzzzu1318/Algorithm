package nov_18;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2043 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int P = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		System.out.println(P-K+1);
	}
}
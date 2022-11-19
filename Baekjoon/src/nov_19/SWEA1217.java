package nov_19;

/* N의 M승 구하기
 * 난이도 : D3
 * 아이디어: 반복문
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int ans = 1;
			for(int i=1;i<=M;i++) {
				ans*=N;
			}
			System.out.println("#"+T+" "+ans);
		}
	}
}
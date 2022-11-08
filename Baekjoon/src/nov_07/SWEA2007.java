package nov_07;

/* 길이 30의 문자열패턴 입력받고 반복되는 패턴이 몇글자인지 출력, 패턴은 최대길이 10
 * 난이도 : D2
 * 아이디어: 문자열을 잘라서 비교 한 후 패턴이 나타나는 가장 작은 수 출력
 * 시간복잡도: ?
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int ans = 10;
			for (int j = 10; j > 0; j--) {
				int cnt = 0;
				for (int k = 0; k < 30 / j - 1; k++) {
					//System.out.println("k: "+k+" str1: "+s.substring(k * j, (k + 1) * j)+" str2: "+s.substring((k + 1) * j, (k + 2) * j));
					if (s.substring(k * j, (k + 1) * j).equals(s.substring((k + 1) * j, (k + 2) * j)) ) {
						cnt++;
					}
					//System.out.println(s);
				}
				//System.out.println(cnt+" "+ 30/j);
				if (cnt == (30 / j) - 1) {
					ans = j;
				}
			}
			System.out.println("#"+(i+1)+" "+ans);
		}
	}
}
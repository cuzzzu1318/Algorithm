package nov_06;

/* 2개의 수를 입력받아 크기를 비교하여 등호 혹은 부등호 출력
 * 난이도 : D1
 * 아이디어: 각 수를 저장 후 비교
 * 시간복잡도: O(n)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2070 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++) {
			String[] s = br.readLine().split(" ");
			int n1 = Integer.parseInt(s[0]);
			int n2 = Integer.parseInt(s[1]);
			String ans = "";
			if(n1>n2) {
				ans=">";
			}else if(n2>n1) {
				ans = "<";
			}else {
				ans = "=";
			}
			System.out.println("#"+(i+1)+" "+ans);
		}
	}
}
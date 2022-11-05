package nov_05;

/* 3 6 9 게임, 박수는 -로 출력
 * 난이도 : D2
 * 아이디어: 수를 문자열로 바꿔서 자리에 3, 6, 9가 포함된 갯수만큼 - 출력
 * 시간복잡도: O(n)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1926 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] clap = { '3', '6', '9' };
		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			ArrayList<Character> iList = new ArrayList<>();
			for (char c : Integer.toString(i).toCharArray()) {
				iList.add(c);
			}
			for (char j : clap) {
				cnt += Collections.frequency(iList, j);
			}
			if(cnt>0) {
				for(int j = 0;j<cnt;j++) {
					System.out.print("-");
				}
			}else {
				System.out.print(i);
			}
			System.out.print(" ");
			
		}
	}
}
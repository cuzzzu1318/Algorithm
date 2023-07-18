package nov_2022;

/* 3 6 9 ����, �ڼ��� -�� ���
 * ���̵� : D2
 * ���̵��: ���� ���ڿ��� �ٲ㼭 �ڸ��� 3, 6, 9�� ���Ե� ������ŭ - ���
 * �ð����⵵: O(n)
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
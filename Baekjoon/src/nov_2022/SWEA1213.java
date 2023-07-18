package nov_2022;

/* ���� ���忡�� Ư���� ���ڿ��� ���� ��ȯ
 * ���̵� : D3
 * ���̵��: ���� ��ü�� ���鼭 ��
 * �ð����⵵: O(str.length())
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			String find = br.readLine();
			String str = br.readLine();
			int cnt = 0;
			for(int i =0;i<str.length()-find.length()+1;i++) {
				if(find.equals(str.substring(i, i+find.length()))) {
					cnt++;
				}
			}
			System.out.println("#"+T+" "+cnt);
		}
	}
}
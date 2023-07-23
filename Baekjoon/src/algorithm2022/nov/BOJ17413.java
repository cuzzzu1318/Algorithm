package algorithm2022.nov;

/* ���̵� : �ǹ� 3
 * ���� ����: ���ڿ� S�� �־����� �� �� ���ڿ����� �ܾ ������. ��, <>�ȿ� �ִ� �±״� ������ �ʴ´�.
 * ���̵��: ���ڿ��� Ž���Ͽ� ������ ���ö����� �����´�, ��ȣ�� ���� �� ������ ����.
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ17413 {

	static void reverse(String s) {
		for(int i = 1;i<=s.length();i++) {
			System.out.print(s.charAt(s.length()-i));
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean isCramp = false;
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				reverse(temp);
				isCramp = true;
				temp = "<";
			}else if(s.charAt(i)=='>') {
				System.out.print(temp+">");
				isCramp = false;
				temp = "";
			}else if(s.charAt(i)==' '&&!isCramp) {
				reverse(temp);
				System.out.print(" ");
				temp = "";
			}else {
				temp+=s.charAt(i);
				if(i==s.length()-1) {
					reverse(temp);
				}
			}
		}
	}
}
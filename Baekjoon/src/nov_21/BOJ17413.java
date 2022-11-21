package nov_21;

/* 난이도 : 실버 3
 * 문제 설명: 문자열 S가 주어졌을 때 이 문자열에서 단어만 뒤집기. 단, <>안에 있는 태그는 뒤집지 않는다.
 * 아이디어: 문자열을 탐색하여 공백이 나올때까지 뒤집는다, 괄호가 있을 시 뒤집지 않음.
 * 시간복잡도:
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
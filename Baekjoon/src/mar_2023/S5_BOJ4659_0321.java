package mar_2023;

/*  발음하기 쉬운 비밀번호 만들기
 * 	rule1: 모음이 하나 이상
 * 	rule2: 모음 혹은 자음이 연속 3자 오면 안됨
 *  rule3: 두개 이상의 같은 글자 안됨. but 'e', 'o'는 가능
 *  조건 만족하는 문자열 찾기
 *  
 * 난이도 : 실버 5
 * 아이디어: 단순 구현.
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ4659_0321 {
	static char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

	static boolean rule1(String s) {
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < vowel.length; j++) {
				if (arr[i] == vowel[j]) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean rule2(String s) {
		char[] arr = s.toCharArray();
		int isVowel = 0;
		int isCons = 0;

		for (int i = 0; i < arr.length; i++) {
			boolean cons = true;
			for (int j = 0; j < vowel.length; j++) {
				if (arr[i] == vowel[j]) {
					isVowel++;
					isCons = 0;
					cons = false;
				}
			}
			if (cons) {
				isCons++;
				isVowel = 0;
			}
			if (isVowel >= 3 || isCons >= 3) {
				return false;
			}
		}
		return true;
	}

	static boolean rule3(String s) {
		char[] arr = s.toCharArray();
		if (arr.length == 1) {
			return true;
		}
		int cnt = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				cnt++;
				if (cnt >= 2) {
					if (arr[i] != 'e' && arr[i] != 'o') {
						return false;
					}
				}
			} else {
				cnt = 1;
			}
		}
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (true) {
			String s = br.readLine();
			if (s.equals("end")) {
				break;
			}
			//System.out.println(s + ": " + rule1(s) + " " + rule2(s) + " " + rule3(s));
			if (rule1(s) && rule2(s) && rule3(s)) {
				bw.write("<" + s + "> is acceptable.\n");
			} else {
				bw.write("<" + s + "> is not acceptable.\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
package jan_27_2023;

/* 숫자야구
 * 난이도 : 실버 3
 * 아이디어: 브루트포스
 * 123부터 시작하여 0이 포함된 것과 중복된 숫자를 제외하고 비교
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2503 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<char[]> arr = new ArrayList<>();
		int[] strike = new int[T];
		int[] ball = new int[T];
		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			arr.add(s[0].toCharArray());
			strike[i] = Integer.parseInt(s[1]);
			ball[i] = Integer.parseInt(s[2]);
		}
		int cnt = 0;
		for (int i = 123; i <= 999; i++) {
			int[] num = new int[3];

			num[0] = i / 100;
			num[1] = (i / 10) % 10;
			num[2] = i % 10;
			if (num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) {
				continue;
			}
			if (num[0] == 0 || num[1] == 0 || num[2] == 0) {
				continue;
			}
			int able = 0;
			for (int j = 0; j < T; j++) {
				int str = 0;
				int ba = 0;
				for (int n1 = 0; n1 < 3; n1++) {
					for (int n2 = 0; n2 < 3; n2++) {
						if (num[n1] == arr.get(j)[n2] - '0') {
							if (n1 == n2) {
								str++;
							} else {
								ba++;
							}
						}
					}
				}
				if (str == strike[j] && ba == ball[j]) {
					able++;
				}
			}
			if(able==T) {
				cnt++;
			}

		}
		System.out.println(cnt);
		
	}
}
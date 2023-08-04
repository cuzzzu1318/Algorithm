package algorithm2023.aug.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_1218_괄호짝짓기 {
	static int len;
	static char[] open = { '{', '[', '<' ,'('};
	static char[] close = { '}', ']', '>' ,')'};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			len = Integer.parseInt(br.readLine());
			boolean check = true;
			char[] str = br.readLine().toCharArray();
			Deque<Character> dq = new ArrayDeque<>();
			loop: for (int i = 0; i < len; i++) {
				char c = str[i];
				for (int j = 0; j < 4; j++) {
					if (c == open[j]) {
						dq.push(c);
						break;
					}
					if (c == close[j]) {
						if(i==0) {
							check = false;
							break loop;
						}
						char prev = dq.pop();
						if (prev != open[j]) {
							check = false;
							break loop;
						}
					}
				}
			}
			if(dq.size()!=0) {
				check = false;
			}
			sb.append("#").append(t).append(" ").append(check?1:0).append("\n");
		}
		System.out.println(sb);
	}

}

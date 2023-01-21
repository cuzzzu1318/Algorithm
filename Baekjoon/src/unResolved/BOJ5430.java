package unResolved;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<String> answer = new ArrayList<>();
		loop: for (int i = 0; i < T; i++) {
			Queue<String> func = new LinkedList<>();
			String[] s = br.readLine().split("");
			for (String str : s) {
				func.add(str);
			}
			int n = Integer.parseInt(br.readLine());

			String st = br.readLine();
			st = st.substring(1, st.length() - 1);
			s = st.split(",");
			int start = 0;
			int end = n - 1;
			int cntR = 0;
			int cntD = 0;
			for (String f : func) {
				if (f.equals("D")) {
					cntD++;
				}
			}
			if (cntD > n) {
				answer.add("error");
				continue loop;
			}
			while (!func.isEmpty()) {
				switch (func.poll()) {
				case "R":
					if (func.peek() == "R") {
						func.poll();
						break;
					}
					int temp = end;
					end = start;
					start = temp;
					cntR++;
					break;
				case "D":
					if (cntR % 2 == 0) {
						start++;
					} else {
						start--;
					}
					if (start > n || start < -1) {
						answer.add("error");
						continue loop;
					}
					break;
				}
			}
			String a = "[";
			if (cntR % 2 == 0) {
				for (int j = start; j <= end; j++) {
					a += s[j];
					if (j < end) {
						a += ",";
					}
				}
			} else {
				for (int j = start; j >= end; j--) {
					a += s[j];
					if (j > end) {
						a += ",";
					}
				}
			}
			a += "]";
			answer.add(a);
		}
		for (String s : answer) {
			System.out.println(s);
		}
	}
}
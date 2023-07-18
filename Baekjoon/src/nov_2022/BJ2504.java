package nov_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class BJ2504 {

	static int calc(Stack<String> st) {
		int res = 0;
		String s;
		while (st.size() > 1) {
			s = st.pop();
			if (s.equals(")")) {
				if (st.peek().equals("(")) {
					return 2 + calc(st);
				} else if (st.peek().equals("]") || st.peek().equals(")")) {
					res += 2 * calc(st);
				} else {
					return -100000;
				}
			} else if (s.equals("]")) {
				if (st.peek().equals("[")) {
					return 3 + calc(st);
				} else if (st.peek().equals("]") || st.peek().equals(")")) {
					res += 3 * calc(st);
				} else {
					return -100000;
				}
			} else if (s.equals("(")) {
				if (st.peek().equals("]") || st.peek().equals(")")) {
					res += calc(st);
				} else if (st.peek().equals("(") || st.peek().equals("[")) {
					// str += ")";
				}
			} else if (s.equals("[")) {
				if (st.peek().equals("]") || st.peek().equals(")")) {
					res += calc(st);
				} else if (st.peek().equals("[") || st.peek().equals("(")) {
					// str += ")";
				}
			}
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		boolean canCalc = true;
		int temp = 1;
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				st.push(c);
				temp *= 2;
			} else if (c == '[') {
				st.push(c);
				temp *= 3;
			} else if (c == ')') {
				if (st.empty() || st.peek() != '(') {
					canCalc = false;
					break;
				} else if (str.charAt(i - 1) == '(') {
					ans += temp;
				}
				st.pop();
				temp /= 2;
			} else {
				if (st.empty() || st.peek() != '[') {
					canCalc = false;
					break;
				} else if (str.charAt(i - 1) == '[') {
					ans += temp;
				}
				st.pop();
				temp /= 3;
			}
		}
		if(!canCalc||!st.isEmpty()) {
			System.out.println("0");
			
		}else {
			System.out.println(ans);
		}
	}
}

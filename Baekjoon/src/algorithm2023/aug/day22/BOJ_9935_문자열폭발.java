package algorithm2023.aug.day22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	
	static String s, explode;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		explode = br.readLine();
		
		Stack<Character> st = new Stack<>();
		for(int i = 0;i<s.length();i++) {
			st.push(s.charAt(i));
			if(st.size()>=explode.length()) {
				boolean flag = true;
				for(int j = 0;j<explode.length();j++) {
					if(st.get(st.size()-explode.length()+j)!=explode.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j= 0;j<explode.length();j++) {
						st.pop();
					}
				}
			}
		}
		
		for(char c : st) {
			sb.append(c);
		}
		System.out.println(sb.length()==0?"FRULA":sb);
		
	}
}



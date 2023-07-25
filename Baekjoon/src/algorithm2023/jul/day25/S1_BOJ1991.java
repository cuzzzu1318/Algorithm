package algorithm2023.jul.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S1_BOJ1991 {
	
	static int N;
	static Map<Character, char[]> tree = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i= 0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			char[] child = new char[2];
			child[0] = s[1].charAt(0);
			child[1] = s[2].charAt(0);
			tree.put(s[0].charAt(0), child);
		}
		preOrder('A');
		sb.append("\n");
		inOrder('A');
		sb.append("\n");
		postOrder('A');
		System.out.println(sb);
	}
	
	static void preOrder(char cur) {
		sb.append(cur);
		char[] child = tree.get(cur);
		for(int i= 0;i<2;i++) {
			if(child[i]!='.') {
				preOrder(child[i]);
			}
		}
	}
	
	
	static void inOrder(char cur) {
		char[] child = tree.get(cur);
		if(child[0]!='.') {
			inOrder(child[0]);
		}
		sb.append(cur);
		if(child[1]!='.') {
			inOrder(child[1]);
		}
	}
	
	
	static void postOrder(char cur) {
		char[] child = tree.get(cur);
		for(int i= 0;i<2;i++) {
			if(child[i]!='.') {
				postOrder(child[i]);
			}
		}

		sb.append(cur);
	}
}
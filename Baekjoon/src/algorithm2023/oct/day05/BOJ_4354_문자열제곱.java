package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4354_문자열제곱 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char[] str;
	static int[] pi;
	
	public static void main(String[] args) throws Exception{
		str = br.readLine().toCharArray();
		while(str[0]!='.'){
			int l = str.length;
			int j = 0;
			pi = new int[l];
			for(int i = 1;i<l;i++) {
				while(j>0&&str[i]!=str[j])j = pi[j-1];
				if(str[i]==str[j])pi[i] = ++j;
			}
//			System.out.println(Arrays.toString(str));
//			System.out.println(Arrays.toString(pi));
			
			int len = l-pi[l-1];
			sb.append(l/len).append("\n");
			
			
			str = br.readLine().toCharArray();
		}
		System.out.println(sb);
	}

}

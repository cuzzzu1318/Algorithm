package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1305_광고 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int L, pi[];
	static char[] str;
	
	public static void main(String[] args) throws Exception{
		L = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		pi = new int[L];
		
		int j = 0;
		for(int i =1;i<L;i++) {
			while(j>0&&str[i]!=str[j])j = pi[j-1];
			if(str[i]==str[j])pi[i] = ++j;
		}
		System.out.println(L-pi[L-1]);
		
	}

}

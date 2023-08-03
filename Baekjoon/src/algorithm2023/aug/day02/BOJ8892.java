package algorithm2023.aug.day02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ8892 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		loop:
		for(int t = 0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			String[] word = new String[k];
			for(int i = 0;i<k;i++) {
				word[i] = br.readLine();
			}
			for(int i = 0;i<k;i++) {
				for(int j= 0;j<k;j++) {
					if(i!=j) {
						StringBuilder sb = new StringBuilder(word[i]).append(word[j]);
						if(isPalin(sb.toString())) {
							System.out.println(sb);
							continue loop;
						}
					}
				}
			}
			System.out.println(0);
		}
	}
	
	
	
	
	static boolean isPalin(String s) {
		for(int i= 0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i))return false;
		}
		return true;
	}
}

package algorithm2023.oct.day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9252_LCS2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static char[] s1, s2;
	static int[][] LCS;
	static ArrayList<Character> ans = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		
		s1 = br.readLine().toCharArray();
		s2  = br.readLine().toCharArray();
		
		LCS = new int[s1.length+1][s2.length+1];
		
		for(int i = 1;i<=s1.length;i++) {
			for(int j=1;j<=s2.length;j++) {
				if(i==0||j==0) {
					LCS[i][j] = 0;
				}else if(s1[i-1] == s2[j-1]) {
					LCS[i][j] = LCS[i-1][j-1]+1;
				}else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
//		for(int i =0;i<=s1.length;i++) {
//			System.out.println(Arrays.toString(LCS[i]));
//		}

		int y = s1.length;
		int x = s2.length;
		int cur = LCS[y][x];
		loop:
		while(cur>0) {
			if(cur==LCS[y-1][x]) {
				y--;
			}else if(cur==LCS[y][x-1]) {
				x--;
			}else {
				ans.add(s2[x-1]);
				y--;
				x--;
				cur = LCS[y][x];
			}
		}
		System.out.println(ans.size());
		for(int i = ans.size()-1;i>=0;i--) {
			System.out.print(ans.get(i));
		}
	}
}

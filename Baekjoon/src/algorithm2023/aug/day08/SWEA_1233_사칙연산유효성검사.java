package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SWEA_1233_사칙연산유효성검사 {
	static int N;
	static boolean[] b;
	static char[] calc =  {'/','*','+','-'};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t =1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			b = new boolean[N];
			for(int i= 0;i<N;i++) {
				char[] s = br.readLine().replace(" ", "").toCharArray();
				for(int j = 0;j<4;j++) {
					if(s[1] == calc[j]) {
						b[s[0]-'0']=true;
					}
				}
			}
		}
		
	}
}

package algorithm2023.oct.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22880_봉화대 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, vill[], arr[], cnt;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		vill = new int[N];
		arr = new int[N];
		arr[0] = 1;
		
		cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			vill[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}

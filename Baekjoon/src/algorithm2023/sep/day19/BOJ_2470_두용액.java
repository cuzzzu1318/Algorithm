package algorithm2023.sep.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, liquid[];
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		for(int i =0 ;i<N;i++) {
			
		}
		
	}
}

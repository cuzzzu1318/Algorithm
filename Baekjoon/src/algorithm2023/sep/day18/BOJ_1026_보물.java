package algorithm2023.sep.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int S = 0;
		for(int i= 0;i<N;i++) {
			S+= A[i]*B[N-1-i];
		}
		System.out.println(S);
	}
	
}

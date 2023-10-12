package unSolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27450_플대그말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,K;
	static int p[], t[];
	
	
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		t = new int[N+1];
		
		st =new StringTokenizer(br.readLine());
		for(int i =1;i<N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		st =new StringTokenizer(br.readLine());
		for(int i =1;i<N;i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}

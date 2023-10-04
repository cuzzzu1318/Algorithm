package algorithm2023.oct.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class __BOJ_1806_부분합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, S;
	static long arr[];
	
	public static void main(String[] args) throws Exception{
		
		st = new StringTokenizer(br.readLine());
		
		//문자열의 길이 N, 합의 최솟값 S
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		//배열의 길이 초기화
		arr = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i =1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =1 ;i<=N;i++) {
			arr[i] = arr[i-1]+arr[i];
		}
		if(arr[N]<S)System.out.println(0);
		else System.out.println(getMinLen(1,N));
		
	}
	
	static int getMinLen(int s, int e) {
		
		if(arr[e]-arr[s-1]<S)return e-s+2;
		
		if(arr[e-1]-arr[s]>=S) {
			return getMinLen(s+1, e-1);
		}else {
			return Math.min(getMinLen(s+1, e), getMinLen(s, e-1));
		}
		
		
		
	}
	
	
}

package study.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, arr[];
	static int bit;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		v = new boolean[N];
		bit = 1<<N;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		subSet(0);
		bitSubSet();
		
		
		
		System.out.println(sb);
	}
	
	//재귀로 구현한 부분집합
	static void subSet(int idx) {
		if(idx==N) {
			print();
			return;
		}
		
		v[idx] = false;
		subSet(idx+1);
		
		v[idx] = true;
		subSet(idx+1);
	}
	
	//비트마스킹으로 구현한 부분집합
	static void bitSubSet() {
		for(int i =0 ;i<bit;i++) {
			for(int j = 0;j<N;j++) {
				if((i&1<<j)>0) {
					sb.append(arr[j]).append(" ");
				}
			}
			sb.append("\n");
		}
	}
	
	static void print() {
		for(int i = 0;i<N;i++) {
			if(v[i]) {
				sb.append(arr[i]).append(" ");
			}
		}
		sb.append("\n");
	}
}

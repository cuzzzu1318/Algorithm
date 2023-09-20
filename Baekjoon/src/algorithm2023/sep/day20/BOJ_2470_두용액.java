package algorithm2023.sep.day20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, liquid[], start, end;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		start = 0;
		end = N-1;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		System.out.println(Arrays.toString(liquid));
		binarySearch(start,end);
		System.out.println(liquid[start]+" "+liquid[end]);
		
	}
	
	static void binarySearch(int low, int high) {
		
	}
}

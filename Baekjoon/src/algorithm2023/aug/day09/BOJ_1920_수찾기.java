package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	static int N,M, arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;i<M;i++) {
			int n = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(arr, n)>=0)sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
		
	}
}

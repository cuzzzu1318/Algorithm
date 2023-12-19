package algorithm2023.dec.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1181_부분수열의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, S,cnt,  arr[];
	static int bit;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		bit = 1<<N;
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1;i<bit;i++) {
			int sum = 0;
			for(int j =0;j<N;j++) {
				if((i&1<<j)>0)sum+=arr[j];
			}
			if(sum==S)cnt++;
		}
		
		System.out.println(cnt);
	}
}

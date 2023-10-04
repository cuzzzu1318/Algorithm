package algorithm2023.oct.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	
	static int N, liquid[], ans[];
	static int min = Integer.MAX_VALUE;
	
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		liquid = new int[N];
		ans = new int[2];
		
		st = new StringTokenizer(br.readLine());	
		for(int i= 0;i<N;i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =0 ;i<N;i++) {
			bs(i);
		}
		Arrays.sort(ans);
		System.out.println(ans[0]+" "+ans[1]);
	}
	
	static void bs(int i) {
		int tgt = -liquid[i];
		int lo = 0;
		int hi = N-1;
		int diff = 0;
		int mid = -1;
		
		while(lo<=hi) {
			mid = (lo+hi)/2;
//			System.out.println(liquid[i]+" "+lo+" "+hi+" "+liquid[mid]);
			
			diff = Math.abs(tgt-liquid[mid]);
//			System.out.println(diff);
			if(diff<min&&i!=mid) {
				min = diff;
				ans[0] = liquid[i];
				ans[1] = liquid[mid];
			}
			if(liquid[mid] == tgt)break;
			
			if(liquid[mid]<tgt) {
				lo = mid+1;
			}else {
				hi = mid-1;
			}
			
		}
	}
}

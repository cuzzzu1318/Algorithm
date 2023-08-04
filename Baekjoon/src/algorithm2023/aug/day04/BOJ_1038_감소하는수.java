package algorithm2023.aug.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1038_감소하는수 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int cnt =0 ;
		long num = 0;
		while(cnt<N) {
			if(isDesc(num++)) {
				cnt++;
			}
		}
		System.out.println(num);
	}
	
	static boolean isDesc(long num) {
		String s = Long.toString(num);
		for(int i = 0;i<s.length()-1;i++) {
			int a = s.charAt(i)-'0';
			int b = s.charAt(i+1)-'0';
			if(b>=a)return false;
		}
		return true;
	}
}

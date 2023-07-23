package algorithm2023.jul.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S4_BOJ1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int cnt = 0;
		boolean[] v = new boolean[N];
		for(int i= 0;i<N;i++) {
			for(int j = i+1;j<N;j++) {
				if(v[i]||v[j]) continue;
				int a= Integer.parseInt(s[i]);
				int b= Integer.parseInt(s[j]);
				if(a+b==M) {
					v[i] = true;
					v[j] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

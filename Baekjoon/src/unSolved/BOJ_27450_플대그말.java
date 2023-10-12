package unSolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27450_플대그말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int p[],sum[];

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		p = new int[N];
		sum = new int[N ];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int t= Integer.parseInt(st.nextToken());
			p[i] = Math.max(0,t-p[i]);
		}
		
		int idx = -1;
		int cnt = 0;
		while(true) {
			if(++idx==N)break;
			if(p[idx]<=0) {
				continue;
			}
			int yell = p[idx]/K;
			if(p[idx]%K>0)yell++;
			cnt+=yell;
			
			for(int i = 1;i<K;i++) {
				if(idx+i==N)break;
				p[idx+i]-=yell*(K-i);
			}
			
		}
		System.out.println(cnt);
		
		
		
	}
}

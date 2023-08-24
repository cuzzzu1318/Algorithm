package algorithm2023.aug.day24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
	static int N, d, k, c, sushi[],ans;
	static int count[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		sushi = new int[N];
		count = new int[d+1];
		
		for(int i =0 ;i<N;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0;i<k;i++) {
			count[sushi[i]]++;
		}
		ans = cnt();
		if(count[c]==0)ans++;
		
		int max = 0;
		
		boolean hasC = false;
		
		for(int i =0;i<N;i++) {
			int old = i;
			int n = (i+k)%N;
			count[sushi[old]]--;
			if(count[sushi[old]]<=0) {
				if(sushi[old] ==c) {
					ans++;
				}
				ans--;
				count[sushi[old]] = 0;
			}
			count[sushi[n]]++;
			if(count[sushi[n]]==1) {
				if(sushi[n]==c) {
					ans--;
				}
				ans++;
			}
			max = Math.max(max, ans);
			
		}
		
		
		System.out.println(max);
	}
	
	static int cnt() {
		int ret = 0;
		for(int i = 1;i<=d;i++) {
			if(count[i]>0)ret++;
		}
		return ret;
	}
	
}

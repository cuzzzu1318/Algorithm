package algorithm2023.aug.day21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static int[] map = new int[100001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N>K) {
			System.out.println(N-K);
		}else {
			Queue<Integer> q = new LinkedList<>();
			q.add(N);
			boolean[] v = new boolean[K+2];
			int time = 0;
			loop:
			while(!q.isEmpty()) {
				int size = q.size();
				for(int s = 0;s<size;s++) {
					int cur = q.poll();
					if(cur==K)break loop;
					if(cur*2<=K+1&&!v[cur*2]) {
						q.offer(cur*2);
						v[cur*2] = true;
					}
					if(cur-1>=0&&!v[cur-1]) {
						q.offer(cur-1);
						v[cur-1] = true;
					}
					if(cur+1<=K&&!v[cur+1]) {
						q.offer(cur+1);
						v[cur+1] = true;
					}
					
				}
				time++;
			}
			System.out.println(time);
		}
		
		
	}
}

package algorithm2023.nov.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int N, C;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i= 0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			max = Math.max(n, max);
			pq.offer(n);
		}
		int start = pq.poll();
		int test = (start+max)/(C-1);
		int ans =Integer.MAX_VALUE;
		int cur = pq.poll();
		//제일 왼쪽에 놓ㅎ고 시작.
		C--;
		while(!pq.isEmpty()&&C>0) {
			int next = pq.poll();
			if(pq.size()==C) {
				C--;
				ans = Math.min(ans, cur-start);
				System.out.println(cur);
				start = cur;
				cur =next;
				continue;
			}
			if(next-start>=test) {
				C--;
				if(Math.abs(next-test)>Math.abs(cur-test)) {
					ans = Math.min(ans, cur-start);
					System.out.println("cur가 더 가까움: "+cur);
					start = cur;
					pq.offer(next);
				}else {
					ans = Math.min(ans, next-start);
					System.out.println("next가 더 가까움: "+next);
					start = next;
				}
			}
			cur =next;
		}
		System.out.println(ans);
	}
}

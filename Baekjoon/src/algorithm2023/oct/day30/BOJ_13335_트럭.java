package algorithm2023.oct.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, w, L;

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int curW = 0;
		int time = 0;
		for(int i = 0;i<w;i++) {
			q.add(0);
		}
		
		for (int i = 0; i < n; i++) {
			int truck = Integer.parseInt(st.nextToken());
			curW-=q.poll();
			time++;
			while(truck+curW>L) {
				time++;
				q.add(0);
				if(q.size()>=w) {
					curW-=q.poll();
					if(truck+curW<=L)break;
				}
			}
			curW+=truck;
			q.add(truck);
//			System.out.println(q);
//			System.out.println(time);
		}
		while(curW>0) {
			curW-=q.poll();
			time++;
		}
		
		System.out.println(time);
	}
}

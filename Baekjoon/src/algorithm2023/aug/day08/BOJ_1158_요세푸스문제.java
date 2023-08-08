package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
	static int N, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N =  Integer.parseInt(st.nextToken());
		K =  Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i= 1;i<=N;i++) {
			list.add(i);
		}
		Queue<Integer> q = new LinkedList<>();
		
		int idx = 0;
		while(!list.isEmpty()) {
			idx = (idx+K-1)%list.size();
			q.offer(list.remove(idx));
			
		}
		sb.append("<");
		for(int i= 0;i<N;i++) {
			sb.append(q.poll());
			if(i!=N-1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}

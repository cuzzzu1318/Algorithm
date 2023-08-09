package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {
			if(Math.abs(o1)==Math.abs(o2)){
				return Math.min(o1,o2);
			}return Math.abs(o1)-Math.abs(o2);
		});
		for(int i= 0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else {
				pq.offer(n);
			}
		}
		System.out.println(sb);
	}
}

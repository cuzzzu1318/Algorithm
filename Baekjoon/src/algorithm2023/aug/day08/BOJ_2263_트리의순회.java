package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2263_트리의순회 {
	static int N;
	static int[] in;
	static int[] post;
	static int[] idx;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		in = new int[N+1];
		post = new int[N+1];
		idx = new int[N+1];
		for (int i = 1; i <= N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
			post[i] = Integer.parseInt(st1.nextToken());
			idx[in[i]] = i;
		}
		pre(1,N,1,N);
		System.out.println(sb);
		
	}
	
	static void pre(int il,int ir, int pl, int pr) {
		System.out.print(post[pr]);
		if(il>=ir)return;
		int head = idx[post[pr]];
		int lsize = head-il;
		int rsize = ir-head;
		pre(il,head-1,pl,pl+lsize);
		pre(head+1,ir, pl+lsize+1,pr);
	}
	
	
	

}

package algorithm2023.aug.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		for(int i= 0;i<=N;i++) {
			tree.add(new ArrayList<>());
		}
		StringTokenizer st;
		for(int i = 0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		int[] parent = new int[N+1];
		Queue<Integer> q= new LinkedList<>();
		boolean[] v = new boolean[N+1];
		q.offer(1);
		v[1] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 0;i<tree.get(cur).size();i++) {
				if(v[tree.get(cur).get(i)])continue;
				parent[tree.get(cur).get(i)] = cur;
				q.offer(tree.get(cur).get(i));
				v[tree.get(cur).get(i)] = true;
			}
		}
		for(int i =2;i<N+1;i++) {
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb);
	}
}

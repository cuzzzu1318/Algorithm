package algorithm2023.aug.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1967_트리의지름 {
	static int n, max;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i =0;i<=n;i++) {
			tree.add(new ArrayList<>());
		}
		Queue<Integer> parent = new LinkedList<>();
		parent.offer(1);
		for(int i= 0;i<n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int p = parent.peek();
			if(a==p)parent.poll();
			tree.get(a).add(new Node(b,c));
			tree.get(b).add(new Node(a,c));
			parent.offer(b);
		}
		while(!parent.isEmpty()) {
			dfs(parent.poll(), 0, new boolean[n+1]);
		}
		System.out.println(max);
		
		
		
		
	}
	
	static void dfs(int num, int cnt, boolean[] v) {
		v[num] = true;
		for(int i =0;i<tree.get(num).size();i++) {
			if(!v[tree.get(num).get(i).num]) {
				dfs(tree.get(num).get(i).num, cnt+tree.get(num).get(i).dist,v);
			}
		}
		max = Math.max(max, cnt);
		v[num] = false;
	}
	
	
	static class Node{
		int num;
		int dist;
		public Node(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
		
	}
}

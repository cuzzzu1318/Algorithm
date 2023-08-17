package algorithm2023.aug.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] v;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i= 0;i<N;i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		boolean flag = false;
		for(int i =0 ;i<N;i++) {
			v = new boolean[N];
			v[i] = true;
			if(dfs(i,1)) {
				flag = true;
				break;
			}
		}
		System.out.println(flag?1:0);
		
	}
	
	static boolean dfs(int cur, int depth) {
		if(depth==5)return true;
		for(int i =0;i<graph.get(cur).size();i++) {
			int next = graph.get(cur).get(i);
				if(v[next])continue;
				v[next] = true;
				if(dfs(next,depth+1)) {
					return true;
				}
				v[next] = false;
		}
		return false;
	}
}

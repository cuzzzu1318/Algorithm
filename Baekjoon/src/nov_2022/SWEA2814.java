package nov_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2814 {


	static int dfs(ArrayList<ArrayList<Integer>> graph, int start, int N, ArrayList<Integer> v, int cnt) {
		int ans = 0;
		int max = cnt;
		for (int i = 0; i < graph.get(start).size(); i++) {
			if(v.contains(graph.get(start).get(i))) {
				continue;
			}
			v.add(graph.get(start).get(i));
			int n = dfs(graph, graph.get(start).get(i), N, v, cnt+1);
			v.remove(v.size()-1);
			if (n > ans) {
				//System.out.println(graph.get(start).get(i)+"->ans: "+n);
				ans = n;
			}
			if(ans>max) {
				max = ans;
			}
		}
		//System.out.println(start+" "+cnt);
		//System.out.println(max);
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				ArrayList<Integer> arr = new ArrayList<>();
				graph.add(arr);
			}
			for (int i = 0; i < M; i++) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			
			
			ArrayList<Integer> v = new ArrayList<>();
			int max = 0;
			for (int i = 1; i <= N; i++) {
				v.add(i);
				//System.out.println(i+"��°");
				int n = dfs(graph, i, N, v,1);
				v.remove(0);
				
				
				//System.out.println("\n n: "+n);
				if (max < n) {
					max = n;
				}
			}
			System.out.println("#" + (t + 1) + " " + max);
		}
	}
}
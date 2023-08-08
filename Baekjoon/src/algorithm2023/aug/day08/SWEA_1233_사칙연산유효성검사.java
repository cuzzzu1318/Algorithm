package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {
	static int N;
	static char[] tree;
	static ArrayList<Character> calc = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		calc.add('-');
		calc.add('*');
		calc.add('/');
		calc.add('+');
		for(int t =1;t<=10;t++) {
			N = Integer.parseInt(br.readLine());
			boolean isValid = true;
			tree = new char[N+1];
			for(int i = 1;i<=N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			while(!q.isEmpty()) {
				int cur = q.poll();
				int lc = cur*2;
				int rc = cur*2+1;
				if(calc.contains(tree[cur])) {
					if(lc>N) {
						isValid = false;
						break;
					}else {
						q.offer(lc);
					}
					if(rc<=N)q.offer(rc);
				}else {
					if(lc<=N) {
						if(calc.contains(tree[lc])) {
							isValid = false;
							break;
						}else {
							q.offer(lc);
						}
					}
					if(rc<=N) {
						if(calc.contains(tree[rc])) {
							isValid = false;
							break;
						}else {
							q.offer(rc);
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(isValid?1:0).append("\n");
		}
		System.out.println(sb);
	}
	
}

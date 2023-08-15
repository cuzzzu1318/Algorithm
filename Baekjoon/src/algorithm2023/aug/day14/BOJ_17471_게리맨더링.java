package algorithm2023.aug.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static int N, popul[];
	static boolean graph[][];
	static boolean[] v;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		popul = new int[N];
		graph = new boolean[N][N];
		v = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int nb = Integer.parseInt(st.nextToken())-1;
				graph[i][nb] = true;
				graph[nb][i] = true;
			}
		}
		for(int i= 0;i<N;i++) {
			v[i] = true;
			gerry(i,popul[i]);
			v[i] = false;
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	
	static void gerry(int start, int cnt) {
		for(int i=0 ;i<N;i++) {
			if(!v[i]) {
				int cnt2 = 0;
				Queue<Integer> q = new LinkedList<>();
				boolean[] v2 = Arrays.copyOf(v, v.length);
				q.add(i);
				cnt2+=popul[i];
				v2[i]=true;
				while(!q.isEmpty()) {
					int cur = q.poll();
					for(int j= 0;j<N;j++) {
						if(!graph[cur][j])continue;
						if(v2[j])continue;
						q.offer(j);
						cnt2+=popul[j];
						v2[j] = true;
					}
				}
				boolean flag = true;
				for(int j =0 ;j<N;j++) {
					if(!v2[j]) {
						flag = false;
					}
				}
				if(flag) {
					for (int a = 0; a < N; a++) {
						System.out.print(v[a] ? a+1+" " : "");
					}
					System.out.println("차이: "+Math.abs(cnt-cnt2));
					min = Math.min(min, Math.abs(cnt-cnt2));
				}
				break;
			}
			
		}
		
		
		
		for(int i = 0;i<N;i++) {
			if(!graph[start][i])continue;
			if(v[i])continue;
			v[i] = true;
			gerry(i,cnt+popul[i]);
			v[i] = false;
		}
	}
	
}

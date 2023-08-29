package algorithm2023.aug.day29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	static int N, cost[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
			
			if(i>0) {
				cost[i][0] = Math.min(cost[i][0]+cost[i-1][1], cost[i][0]+cost[i-1][2]);
				cost[i][1] = Math.min(cost[i][1]+cost[i-1][0], cost[i][1]+cost[i-1][2]);
				cost[i][2] = Math.min(cost[i][2]+cost[i-1][1], cost[i][2]+cost[i-1][0]);
			}
		}
		System.out.println(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])));
		
		
	}
}

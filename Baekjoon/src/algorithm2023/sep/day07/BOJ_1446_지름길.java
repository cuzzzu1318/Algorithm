package algorithm2023.sep.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, D, road[];

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		road = new int[D+1];
		for(int i =0;i<=D;i++) {
			road[i] = i;
		}
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(e>D)continue;
			if(road[e]>road[s]+d) {
				for(int j =e;j<D+1;j++) {
					if(road[j]<road[s]+d+(j-e))break;
					road[j] = road[s]+d+(j-e);
				}
			}
		}
		
		System.out.println(road[D]);
	}
}

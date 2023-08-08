package algorithm2023.aug.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_27172_수나누기게임 {
	static int N, score[], card[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		score = new int[1_000_001];
		boolean[] v = new boolean[1_000_001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i= 0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			card[i] = n;
			v[n] = true;
		}
		
		for(int n : card) {
			for(int i = 2*n;i<1000001;i+=n) {
				if(v[i]) {
					score[i]--;
					score[n]++;
				}
			}
		}
		for(int i= 0;i<N;i++) {
			sb.append(score[card[i]]).append(" ");
		}
		System.out.println(sb);
	}
}

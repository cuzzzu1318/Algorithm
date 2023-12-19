package study.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, src[], tgt[];
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		src =new int[N];
		tgt = new int[N];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
//		perm(0);
		repetitionPerm(0);
		
		
		System.out.println(sb);
		
	}
	
	//순열
	static void perm(int idx) {
		if(idx == N) {
			sb.append(Arrays.toString(tgt)).append("\n");
			return;
		}
		
		for(int i = 0;i<N;i++) {
			if(!v[i]) {
				v[i] = true;
				tgt[idx] = src[i];
				perm(idx+1);
				v[i]=false;
			}
		}
		
		
	}
	
	//중복순열
	static void repetitionPerm(int idx) {
		if(idx == N) {
			sb.append(Arrays.toString(tgt)).append("\n");
			return;
		}
		
		for(int i = 0;i<N;i++) {
				tgt[idx] = src[i];
				perm(idx+1);
		}
		
		
	}

	
}

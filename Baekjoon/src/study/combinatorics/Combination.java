package study.combinatorics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Combination {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, src[], tgt[];
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src =new int[N];
		tgt = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		repetitionComb(0, 0);
		
		System.out.println(sb);
		
	}
	
	//조합
	static void comb(int sIdx, int tIdx) {
		if(tIdx==M) {
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		for(int i = sIdx;i<N;i++) {
			tgt[tIdx] = src[i];
			comb(i+1,tIdx+1);
		}
	}
	
	//중복조합
	static void repetitionComb(int sIdx, int tIdx) {
		if(tIdx==M) {
			System.out.println(Arrays.toString(tgt));
			return;
		}
		
		for(int i = sIdx;i<N;i++) {
			tgt[tIdx] = src[i];
			comb(i,tIdx+1);
		}
	}
	
}

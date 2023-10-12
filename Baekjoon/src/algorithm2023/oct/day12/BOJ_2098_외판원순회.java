package algorithm2023.oct.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098_외판원순회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,allMask,INF=999_999_999;
	static int W[][], memoi[][], ans;
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		allMask = (1<<N)-1;
		memoi = new int[N][allMask+1];
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<N;j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		System.out.println(tsp(0,1));
	}
	
	static int tsp(int x, int mask) {
		if(mask==allMask) {
			if(W[x][0]==0)return INF;
			memoi[x][mask] = W[x][0];
			return W[x][0];
		}
		if(memoi[x][mask]!=0)return memoi[x][mask];
		
		memoi[x][mask] = INF;
		
		for(int i =1;i<N;i++) {
			if((mask&(1<<i))>1||W[x][i]==0) {
				continue;
			}
			int nextM = mask|(1<<i);
			int next = tsp(i,nextM)+W[x][i];
			if(next<memoi[x][mask]) {
				memoi[x][mask] = next;
			}
			
		}//
		return memoi[x][mask];
	}
}

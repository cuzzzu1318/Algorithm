package algorithm2023.aug.day03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int N, S[], B[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int subSetCnt = 1<<N;

		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1;i<subSetCnt;i++) {
			int sSum = 1;
			int bSum = 0;
			for(int j= 0;j<N;j++) {
				if((i&1<<j)==0)continue;
				sSum*=S[j];
				bSum+=B[j];
			}
			min = Math.min(min, Math.abs(sSum-bSum));
		}
		System.out.println(min);
	}
	
	
	
}

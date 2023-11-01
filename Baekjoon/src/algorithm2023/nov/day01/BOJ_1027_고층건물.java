package algorithm2023.nov.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static int[] buildings;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		buildings = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<=N;i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(buildings));
		int ans = 0;
		for(int i =1;i<=N;i++) {
			int x = i;
			int y = buildings[i];
			double d = y+1;
			int cnt = 0;
			for(int j = i-1;j>0;j--) {
				int nx = j;
				int ny = buildings[j];
				double nd = (double)(y-ny)/(double)(x-nx);
				if(nd<d) {
					cnt++;
					d = nd;
				}else {
					break;
				}
				System.out.println("0이 어캐 나와: "+y+" "+ny+" "+nd);
			}
			System.out.println(i+" "+cnt);
			d = y+1;
			for(int j = i+1;j<=N;j++) {
				int nx = j;
				int ny = buildings[j];
				double nd =(double)(y-ny)/(double)(nx-x);
				if(nd<d) {
					cnt++;
					d = nd;
				}else {
					break;
				}
				System.out.println(nd);
				System.out.println("0이 어캐 나와: "+y+" "+ny+" "+nd);
			}
			System.out.println(i+" "+cnt);
			System.out.println();
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}

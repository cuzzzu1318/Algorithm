package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class G4_BOJ15683_0527 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,-1,0};
	static int N;
	static int M;
	static int[][] map;
	static LinkedList<cctv> cam = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][M+2];
		for(int i= 0;i<N+2;i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i= 1;i<=N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0&&map[i][j]<6) {
					cam.add(new cctv(i,j,map[i][j]));
				}
			}
		}
		
		
		
	}
	
	static int watch(int d, int idx, int cnt) {
		cctv cctv = cam.get(idx);
		
		return cnt;
	}
	
	static class cctv{
		int x;
		int y;
		int num;
		cctv(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
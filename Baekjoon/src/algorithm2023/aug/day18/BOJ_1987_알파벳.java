package algorithm2023.aug.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R, C, max;
	static char[][] board;
	
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for(int i =0;i<R;i++) {
			board[i] = br.readLine().toCharArray();
		}
		dfs(0,0,1<<(board[0][0]-'A'), 1);
		System.out.println(max);
	}
	
	static void dfs(int y, int x, int bitMask, int cnt) {
		if(cnt>max) {
			max = cnt;
		}
		for(int d = 0;d<4;d++) {
			int ny =y+dy[d];
			int nx = x+dx[d];
			if(isValid(ny,nx)) {
				int next = board[ny][nx] - 'A';
				if((bitMask&1<<next)==0) {
					dfs(ny,nx,bitMask|(1<<next),cnt+1);
				}
			}
		}
	}
	
	static boolean isValid(int y, int x) {
		if(y<0||x<0||y>=R||x>=C)return false;
		return true;
	}
}

package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G5_BOJ10026_0515 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class idx{
		int x;
		int y;
		public idx(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		char[][] pic = new char[N + 2][N + 2];
		//그림의 색 정보, 패딩을 위해 인덱스를 2씩 추가
		for (int i = 1; i <= N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				pic[i][j] = s[j-1];
			}
		}

		Queue<idx> q = new LinkedList<>();
		
		int[] cnt = {0,0};
		//0번째 인덱스는 색약이 아닌 경우, 1번째 인덱스는 색약인 경우의 색 구역 수
		
		boolean[][] v = new boolean[N + 2][N + 2];
		
		//색약이 아닌 경우
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(!v[i][j]) {
					//한번 방문할 때 구역의 수를 더하고 구역 탐색
					cnt[0]++;
					idx idx = new idx(i,j);
					q.add(idx);
					v[i][j]=true;
					while(!q.isEmpty()) {
						idx cur = q.poll();
						char c = pic[cur.x][cur.y];
						for(int d = 0;d<4;d++) {
							int x = cur.x+dx[d];
							int y = cur.y+dy[d];
							if(c==pic[x][y]&&!v[x][y]) {
								//색약이 아닌 경우이므로 색이 같은 경우만 탐색
								q.add(new idx(x,y));
								v[x][y] = true;
							}
						}
						cur=null;
					}
					
				}
			}
		}
		v = new boolean[N + 2][N + 2];
		//다시 탐색해야 하므로 방문배열 초기화
		
		//색약인 경우
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(!v[i][j]) {
					cnt[1]++;
					idx idx = new idx(i,j);
					q.add(idx);
					v[i][j]=true;
					while(!q.isEmpty()) {
						idx cur = q.poll();
						char c = pic[cur.x][cur.y];
						for(int d = 0;d<4;d++) {
							int x = cur.x+dx[d];
							int y = cur.y+dy[d];
							if(isSame(c, pic[x][y])&&!v[x][y]) {
								//R과 G를 같은 값으로 봐야 하므로 별도의 함수로 구별
								q.add(new idx(x,y));
								v[x][y] = true;
							}
						}
					}
					
				}
			}
		}
		System.out.println(cnt[0]+" "+cnt[1]);
	}
	static boolean isSame(char c1, char c2) {
		//R과 G를 같은 값으로 판단하는 함수
		if(c1=='R'&&c2=='G') {
			return true;
		}else if(c1=='G'&&c2=='R') {
			return true;
		}else if(c1==c2) {
			return true;
		}return false;
	}
}
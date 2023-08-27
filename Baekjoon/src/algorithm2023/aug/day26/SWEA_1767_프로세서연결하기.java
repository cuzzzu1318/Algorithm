package algorithm2023.aug.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기 {
	static int N, connected, len, mex[][];
	//코어를 저장하여 사용
	static ArrayList<Core> core;

	//상 우 하 좌 네 방향과 전선을 연결하지 않는 경우인 0,0 추가
	static int[] dy = { -1, 0, 1, 0, 0 };
	static int[] dx = { 0, 1, 0, -1, 0 };
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			// N*N 크기의 멕시노스
			mex = new int[N][N];
			core = new ArrayList<>();
			connected = 0;
			len = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mex[i][j] = Integer.parseInt(st.nextToken());
					if(j>0&&i>0&&j<N-1&&i<N-1&&mex[i][j]==1) {
						core.add(new Core(i,j,4));
					}
				}
			}

			/* 입력 종료 */
			
			//프로세서가 연결될 방향을 모두 구해서 계산
			comb(0, 0);
			sb.append("#").append(t).append(" ").append(len).append("\n");
		}
		System.out.println(sb);
	}
	
	//가능한 조합을 모두 탐색 + 백트래킹 사용
	//방향을 조작할 프로세서를 정하기 위한 idx와 연결된 프로세서의 개수를 표시하기 위한 conn 변수
	static void comb(int idx, int conn) {
		//모든 프로세서의 방향을 결정한 경우
		if(idx==core.size()) {
			//연결 된 프로세서의 개수가 현재까지 기록한 것보다 많으면
			if(conn>connected) {
				//연결된 프로세서 개수의 최대값 갱신
				connected = conn;
				//전선의 길이 갱신
				len = count();
			//같다면
			}else if(conn==connected) {
				//전선 길이의 최소값으로 갱신
				len = Math.min(len, count());
			}
			return;
		}
		
		//현재 방향을 결정해 줄 코어
		Core c = core.get(idx);
		//네 방향을 모두 탐색
		for(int i=0 ;i<4;i++) {
			 c.d= i;
			 //만약 해당 방향으로 전선을 깔 수 있다면 해당 경우의 수를 탐색, 깔 수 없다면 가지치기
			if(connect(c.y+dy[c.d],c.x+dx[c.d],c)) {
				comb(idx+1,conn+1);
				//전선을 깔아서 탐색한 후에는 해당 방향의 전선 모두 제고
				remove(c);
			}
		}
		//전원을 연결하지 않는 경우도 진행
		c.d = 4;
		comb(idx+1,conn);
		
	}
	
	//재귀를 통해 해당 방향으로 전선을 연결할 수 있는지 확인
	static boolean connect(int y, int x, Core c) {
		//범위밖으로 나간 경우 -> 끝점까지 탐색한 것이므로 true 반환
		if(y<0||x<0||y>=N||x>=N)return true;
		//해당 공간이 빈 칸이 아니라면 false반환
		if(mex[y][x] !=0)return false;
		//다음 칸으로 재귀하며 true라면 전선을 표시하기 위해 2로 갱신 후 true 리턴
		if(connect(y+dy[c.d], x+dx[c.d], c)) {
			mex[y][x] = 2;
			return true;
		}
		return false;
	}
	
	//깔았던 전선 모두 제거
	static void remove(Core c) {
		int y = c.y;
		int x= c.x;
		int d= c.d;
		
		//해당 방향에으로 진행하며 2가 없을 때 까지 제거
		while(true) {
			y+=dy[d];
			x+=dx[d];
			if(y<0||x<0||y>=N||x>=N||mex[y][x]!=2)break;
			mex[y][x] = 0;
		}
	}
	
	//2(전선)을 카운트
	static int count() {
		int cnt = 0;
		for(int i= 0;i<N;i++) {
			for(int j= 0;j<N;j++) {
				if(mex[i][j] == 2) {
					cnt++;
				}
			}
		}
		
		
		return cnt;
	}
	
	
	//코어를 표현하기 위한 클래스. 방향을 정해주기 위해 d변수 추가
	static class Core{
		int y;
		int x;
		int d;
		
		public Core(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}

		@Override
		public String toString() {
			return y + ", " + x + ", " + d + "\t";
		}
		
		
		
		
	}
}

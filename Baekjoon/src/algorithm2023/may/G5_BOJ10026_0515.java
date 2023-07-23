package algorithm2023.may;

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
		//�׸��� �� ����, �е��� ���� �ε����� 2�� �߰�
		for (int i = 1; i <= N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				pic[i][j] = s[j-1];
			}
		}

		Queue<idx> q = new LinkedList<>();
		
		int[] cnt = {0,0};
		//0��° �ε����� ������ �ƴ� ���, 1��° �ε����� ������ ����� �� ���� ��
		
		boolean[][] v = new boolean[N + 2][N + 2];
		
		//������ �ƴ� ���
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(!v[i][j]) {
					//�ѹ� �湮�� �� ������ ���� ���ϰ� ���� Ž��
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
								//������ �ƴ� ����̹Ƿ� ���� ���� ��츸 Ž��
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
		//�ٽ� Ž���ؾ� �ϹǷ� �湮�迭 �ʱ�ȭ
		
		//������ ���
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
								//R�� G�� ���� ������ ���� �ϹǷ� ������ �Լ��� ����
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
		//R�� G�� ���� ������ �Ǵ��ϴ� �Լ�
		if(c1=='R'&&c2=='G') {
			return true;
		}else if(c1=='G'&&c2=='R') {
			return true;
		}else if(c1==c2) {
			return true;
		}return false;
	}
}
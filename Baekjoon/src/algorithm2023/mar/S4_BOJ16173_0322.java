package algorithm2023.mar;

/*  �� ĭ�� ���� ���ڸ�ŭ ĭ �̵� ����.
 *  �� ���� ������ ����ؼ� �� ������ �Ʒ��� �� �� ������ HaruHaru, �ȵǸ� Hing ���
 * ���̵� : �ǹ� 4
 * ���̵��: ��� �̿��ؼ� ���� �Ѿ�� �õ� x, �����ϸ� ��.
 * �ð����⵵:
 * �ҿ� �ð�: 09:04~09:25 (21min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S4_BOJ16173_0322 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean[][] v;
	
	static int canWin(int[][] map, int x, int y) throws IOException {
		int cnt = 0;
		int n = map[x][y];
		//bw.write(x+" "+y+"\n");
		if(v[x][y]) {
			return 0;
		}
		v[x][y]=true;
		if(x==N-1&&y==N-1) {
			return 1;
		}else {
			for(int i = 0;i<2;i++) {
				if(x+dx[i]*n>=N||y+dy[i]*n>=N) {
					continue;
				}else {
					cnt+=canWin(map,x+dx[i]*n, y+dy[i]*n);
					//bw.write(cnt+"\n");
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		v = new boolean[N][N];
		for(int i = 0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0;j<N;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		if(canWin(map,0,0)>0) {
			bw.write("HaruHaru");
		}else {
			bw.write("Hing");
		}
		bw.flush();
		bw.close();
		
	}
}
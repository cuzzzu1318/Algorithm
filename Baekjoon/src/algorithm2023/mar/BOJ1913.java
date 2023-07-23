package algorithm2023.mar;

/*  �߰����� ������ ä���
 * ���̵� : �ǹ� 3
 * ���̵��: ���⺤�� ���
 * �ð����⵵:
 * �ҿ� �ð�: 13:25~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1913 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	// �� �� �� �� ������ ���⺤��
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		int x = N/2;
		int y = N/2;
		//��������--�߾� ��ǥ
		int cnt = 0;
		int dirC = 2;
		int dir = 0;
		for(int i = 1;i<=N*N;i++) {
			arr[x][y]=i;
			x+=dx[dir];
			y+=dy[dir];
			cnt++;
			if(cnt==dirC/2) {
				dir++;
				cnt=0;
				dirC++;
				if(dir>3) {
					dir=0;
				}
			}
			//System.out.println(x+" "+y);
			
		}
		
		int ansX = -1;
		int ansY = -1;
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(arr[i][j]==num) {
					ansX = i+1;
					ansY = j+1;
				}
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		bw.write(ansX+" "+ansY);
		bw.flush();
		bw.close();
	}
}
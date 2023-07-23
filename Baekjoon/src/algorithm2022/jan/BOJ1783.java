package algorithm2022.jan;
/*  
 * ���̵� : �ǹ� 3 ���� ����Ʈ
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1783 {
	
	static int[] dx = {2,-2,1,-1};
	static int[] dy = {1,1,2,2};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] cur = {0,0};
		int cnt = 1;
		if(N>=2||M>=6) {
			for(int i = 0;i<4;i++) {
				cur[0]+=dx[i];
				cur[1]+=dy[i];
				cnt+=dx[i]+dy[i];
			}
		}
		while(cur[0]<N-1&&cur[1]<M&&cur[0]>=0&&cur[1]>=0) {
			if(cur[0]>N/2) {
				if(cur[0]>=2) {
					cur[0]+=dx[1];
					cur[1]+=dy[1];
					cnt+=dx[1]+dy[1];
				}else {
					cur[0]+=dx[2];
					cur[1]+=dy[2];
					cnt+=dx[2]+dy[2];
				}
			}else {
				if(cur[0]<N-2) {
					cur[0]+=dx[0];
					cur[1]+=dy[0];
					cnt+=dx[0]+dy[0];
				}else {
					cur[0]+=dx[3];
					cur[1]+=dy[3];
					cnt+=dx[3]+dy[3];
				}
			}
			System.out.println(cur[0]+" "+cur[1]+" "+cnt);
		}
		System.out.println(cnt);
		
	}
}
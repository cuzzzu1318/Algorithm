package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_BOJ14891_0524 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] chain = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				chain[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		
		int K = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			//인덱스로 사용하기 위해 -1해줌.
			int d = Integer.parseInt(st.nextToken());
			int[] t = new int[4];
			//회전하는지 나타내기 위한 배열
			
			t[num] = d;
			check(chain,t,num);
			//회전체크
			turn(t, chain);
			//회전
		}
		int sum = 0;
		for(int i= 0;i<4;i++) {
			if(chain[i][0]==1) {
				sum+=Math.pow(2, i);
			}
		}
		System.out.println(sum);
	}
	
	static void check(int[][] chain, int[] t, int num) {
		
		for(int i = num-1;i>=0;i--) {
			//왼쪽으로 체크
			if(chain[i][2]!=chain[i+1][6]) {
				//맞닿은 부분이 다르면 반대방향 회전 체크
				t[i]= -t[i+1];
			}else {
				//톱니가 회전하지 않ㅇ으면 다음 톱니도 회전 x
				break;
			}
		}
		for(int j = num+1;j<4;j++) {
			//오른쪽으로 체크
			if(chain[j-1][2]!=chain[j][6]) {
				t[j]= -t[j-1];
			}else {
				break;
			}
		}
	}
	
	static void turn(int[] t, int[][] chain) {
		for(int i= 0;i<4;i++) {
			if(t[i] ==1) {
				//1인 경우 시계방향 회전
				int temp = chain[i][7];
				for(int j = 7;j>0;j--) {
					chain[i][j] = chain[i][j-1];
				}
				chain[i][0] = temp;
			}
			if(t[i] == -1) {
				//-1인 경우 반시계 방향 회전
				int temp = chain[i][0];
				for(int j = 0;j<7;j++) {
					chain[i][j] = chain[i][j+1];
				}
				chain[i][7] = temp;
			}
		}
	}
}
package algorithm2023.may;

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
			//�ε����� ����ϱ� ���� -1����.
			int d = Integer.parseInt(st.nextToken());
			int[] t = new int[4];
			//ȸ���ϴ��� ��Ÿ���� ���� �迭
			
			t[num] = d;
			check(chain,t,num);
			//ȸ��üũ
			turn(t, chain);
			//ȸ��
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
			//�������� üũ
			if(chain[i][2]!=chain[i+1][6]) {
				//�´��� �κ��� �ٸ��� �ݴ���� ȸ�� üũ
				t[i]= -t[i+1];
			}else {
				//��ϰ� ȸ������ �ʤ����� ���� ��ϵ� ȸ�� x
				break;
			}
		}
		for(int j = num+1;j<4;j++) {
			//���������� üũ
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
				//1�� ��� �ð���� ȸ��
				int temp = chain[i][7];
				for(int j = 7;j>0;j--) {
					chain[i][j] = chain[i][j-1];
				}
				chain[i][0] = temp;
			}
			if(t[i] == -1) {
				//-1�� ��� �ݽð� ���� ȸ��
				int temp = chain[i][0];
				for(int j = 0;j<7;j++) {
					chain[i][j] = chain[i][j+1];
				}
				chain[i][7] = temp;
			}
		}
	}
}
package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_BOJ1992_0507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
	   int N = Integer.parseInt(br.readLine());
	  tree = new int[N][N];
	   for(int i =0;i<N;i++) {
		   String[] s = br.readLine().split("");
		   for(int j = 0;j<N;j++) {
			   tree[i][j] = Integer.parseInt(s[j]);
		   }
	   }
	   //�Է�
	   
	   print(0,0,N);
	   System.out.println(sb);
   }

	static void print(int x, int y, int l) {
		boolean isOne = true;
		//�ϳ��� �����ͷ� �� �������� Ȯ���� ����
		int n = tree[x][y];
		//ù��° ��ǥ�� ��
		loop:
		for(int i =x;i<x+l;i++) {
			for(int j =y;j<y+l;j++) {
				if(tree[i][j]!=n) {
					//�����͸� Ž���ϰ� �ٸ����� �ϳ��� �ִٸ� �ϳ��� �����ͷ� �� ������ �ƴ�.
					isOne = false;
					break loop;
				}
			}
		}
		
		if(isOne) {
			//��� n���� �̷���� �ִٸ� n���
			sb.append(n);
		}else {
			//�ƴ϶�� �ٽ� Ž��, ��ȣ�� �߰��Ͽ� ���
			sb.append("(");
			print(x, y, l/2);
			print(x, y+l/2, l/2);
			print(x+l/2, y, l/2);
			print(x+l/2, y+l/2, l/2);
			
			sb.append(")");
		}
	}
   
}
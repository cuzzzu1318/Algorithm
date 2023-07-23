package algorithm2023.mar;

/*  ����
 * ���̵� : �ǹ� 1
 * ���̵��: �ٸ���� �ڵ� ������...
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S1_BOJ2615_0327{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[19][19];
		int [][] d = {{0,1}, {1,0}, {1,1}, {-1,1}};
		
		//		board �Է¹ޱ�
		for (int i = 0; i < 19; i++) {
			String input = br.readLine();
			for (int j = 0, index = 0; j < 19; index += 2, j++) {
				board[i][j] = input.charAt(index);
			}
		}
		
		
		// ��� ĭ�� ���� ���� �ϼ� ã��		
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (board[i][j] == '1' || board[i][j] == '2') {
					for (int k = 0; k < 4; k++) {
						int ax = i; // x��ǥ
						int ay = j; // y��ǥ
						int cnt = 1; // ��ġ�ϴ� �ٵϾ��� ����
						
						// �����ϴ� ���� Ž��
						while (true) {
							ax += d[k][0];
							ay += d[k][1];
							if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
								if(board[i][j] == board[ax][ay])cnt ++;
								else {
									break;
								}
							} else break;
						}
						ax = i;
						ay = j;
						
						// �����ϴ� ������ �ݴ���� Ž��
						while( true) {
							ax -= d[k][0];
							ay -= d[k][1];
							if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
								if(board[i][j] == board[ax][ay])cnt ++;
								else break;

							} else break;
						}
						
						// ���� ������ 5�����
						if (cnt == 5) {
							System.out.println(board[i][j]);
							System.out.println((i+1) + " " + (j+1));
							return;
						}
						
					}
				}
			}
		}
		
//		�ƹ��� �̱��� �ʾ��� ���
		System.out.println(0); 	
		
		
	}	
}
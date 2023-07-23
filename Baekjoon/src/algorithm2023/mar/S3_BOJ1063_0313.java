package algorithm2023.mar;

/*  8*8ũ���� ü���ǿ� ŷ�� �ְ� ��ġ�� �־���.
 * ��ġ�� ���ĺ�(�� - A~H)�� ����(�� - 1~8)
 * ü���ǿ��� ���� �ϳ� �ְ� ���� ���� ������ �̵��� ���� ���� ŷ�� �Բ� ���� �������� ������.
 * ���̵� : �ǹ� 3
 * ���̵��: ���⺤�� �̿�, �ܼ� ����
 * 			��ǥ �ݴ�� �� �򰥷Ƚ�
 * �ð����⵵:
 * �ҿ� �ð�: 20:13~21:05 (52min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S3_BOJ1063_0313 {

	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static String[] dir = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	// R L B T RT LT RB LB ���� ���⺤��
	static int[][] board = new int[8][8];
	static int N;

	static int retIndex(String s) {
		switch (s) {
		case "R":
			return 0;
		case "L":
			return 1;
		case "B":
			return 2;
		case "T":
			return 3;
		case "RT":
			return 4;
		case "LT":
			return 5;
		case "RB":
			return 6;
		default:
			return 7;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		for (int[] arr : board) {
			Arrays.fill(arr, 0);
		}
		char[] king = s[0].toCharArray();
		int kingX = king[0] - 64;
		int kingY = king[1] - '0';
		//System.out.println(kingX+" "+kingY);
		char[] stone = s[1].toCharArray();
		int stoneX = stone[0] - 64;
		int stoneY = stone[1] - '0';
		N = Integer.parseInt(s[2]);

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int index = retIndex(s[0]);
			int nextX = kingX + dx[index];
			int nextY = kingY + dy[index];
			if (nextX == stoneX && nextY == stoneY) {
				nextX += dx[index];
				nextY += dy[index];
				if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <= 8) {
					stoneX = nextX;
					stoneY = nextY;
					kingX = nextX - dx[index];
					kingY = nextY - dy[index];
					//System.out.println(kingX+" "+kingY+" "+stoneX+" "+stoneY);
				}
			} else {
				//System.out.println("emfdjdha "+nextX+" "+nextY);
				if (nextX >= 1 && nextX <= 8 && nextY >= 1 && nextY <= 8) {
					kingX = nextX;
					kingY = nextY;
					//System.out.println("else "+kingX+" "+kingY+" "+stoneX+" "+stoneY);
				}
			}
		}

		System.out.println((char) (kingX + 64) + "" + kingY + "\n" + (char) (stoneX + 64) + "" + stoneY);

	}
}
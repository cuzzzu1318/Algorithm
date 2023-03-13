package mar_2023;

/*  8*8크기의 체스판에 킹이 있고 위치가 주어짐.
 * 위치는 알파벳(열 - A~H)과 숫자(행 - 1~8)
 * 체스판에는 돌이 하나 있고 돌과 같은 곳으로 이동할 때는 돌이 킹과 함께 같은 방향으로 움직임.
 * 난이도 : 실버 3
 * 아이디어: 방향벡터 이용, 단순 구현
 * 			좌표 반대라 좀 헷갈렸슴
 * 시간복잡도:
 * 소요 시간: 20:13~21:05 (52min)
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
	// R L B T RT LT RB LB 순서 방향벡터
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
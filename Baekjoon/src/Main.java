import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[4 * N - 1][4 * N - 3];
		for (char[] c : arr) {
			Arrays.fill(c, ' ');
		}
		int y = 2 * N;
		int x = 2 * (N - 1);
		arr[y][x] = '*';
		if (N == 1) {
			System.out.println("*");
		} else {
			draw(y, x);
			for(int i = 0;i<arr.length;i++) {
				for(int j= 0;j<arr[0].length;j++) {
					if(i==1&&j>0) {
						break;
					}
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}

	static void draw(int y, int x) {
		int len = 0;
		while (true) {
			for (int d = 0; d < 4; d++) {
				switch (d) {
				case 0:
					len += 2;
					break;
				case 2:
					len += 2;
					break;
				}
				for (int i = 0; i < len; i++) {
					y += dy[d];
					x += dx[d];
					if (x >= arr[0].length) {
						return;
					}
					arr[y][x] = '*';
				}
			}
		}

	}
}
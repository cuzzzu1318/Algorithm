package mar_2023;

/*  c는 구름, .은 그냥 하늘.
 * 	1초마다 구름은 오른쪽으로 움직임.
 * 	몇초 후에 구름이 나타나는지 표시
 * 난이도 : 실버 5
 * 아이디어: 단순 구현
 * 시간복잡도:
 * 소요 시간: 한 10분 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ10709_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int H;
	static int W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		H = Integer.parseInt(s[0]);
		W = Integer.parseInt(s[1]);
		for (int i = 0; i < H; i++) {
			s = br.readLine().split("");
			int cnt = -1;
			boolean hasCloud = false;
			for (int j = 0; j < W; j++) {

				if (s[j].equals("c")) {
					cnt = 0;
					hasCloud = true;
				} else {
					if (hasCloud) {
						cnt++;
					} else {
						bw.write("-1 ");
						continue;
					}
				}
				bw.write(cnt+" ");
			}
			bw.write("\n");

		}
		bw.flush();
		bw.close();

	}
}
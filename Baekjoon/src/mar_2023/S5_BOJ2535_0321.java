package mar_2023;

/*  나라별 학생 번호와 점수가 주어질때 금,은,동메달 수상자 출력.
 * 	but, 한 나라에 수상자가 두명을 초과할 수 없음.
 * 난이도 : 실버 5
 * 아이디어: 점수 배열을 새로 만들어서 정렬 후 찾아서 출력. 나라는 출력될때마다 횟수를 기록.
 * 시간복잡도:
 * 소요 시간: 20:41~ 20:58 (17min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class S5_BOJ2535_0321 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		int[][] scores = new int[N][3];
		int[] sorted = new int[N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			scores[i][0] = Integer.parseInt(s[0]);
			scores[i][1] = Integer.parseInt(s[1]);
			scores[i][2] = Integer.parseInt(s[2]);
			
			sorted[i] = scores[i][2];
		}
		Arrays.sort(sorted);
		int[] countrys = new int[101];
		int cnt =0;
		for(int i = sorted.length-1;i>=0;i--) {
			if(cnt>=3) {
				break;
			}
			for(int j = 0;j<N;j++) {
				if(scores[j][2]==sorted[i]) {
					if(countrys[scores[j][0]]>=2) {
						break;
					}else {
						countrys[scores[j][0]]++;
						bw.write(scores[j][0]+" "+scores[j][1]+"\n");
						cnt++;
					}
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
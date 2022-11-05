package nov_05;

/* N*N	배열에 각 칸에 파리가 여러마리 앉아있을때 M*M크기의 파리채로 가장 많은수의 파리 잡기
 * 난이도 : D2
 * 아이디어: 모든 배열을 탐색 후 최댓값 출력
 * 시간복잡도: 4중첩 for문,,
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> ansList = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] table = new int[N][N];
			ArrayList<Integer> valList = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String[] str = br.readLine().split(" ");
				for (int k = 0; k < N; k++) {
					table[j][k] = Integer.parseInt(str[k]);
				}
			}
			for (int j = 0; j <= N-M; j ++) {
				for (int k = 0; k <= N-M; k ++) {
					int sum = 0;
					for (int n1 = j; n1 < j + M; n1++) {
						for (int n2 = k; n2 < k + M; n2++) {
							sum+=table[n1][n2];
						}
					}
					valList.add(sum);
				}
			}
			valList.sort(null);
			System.out.println("#"+(i+1)+" "+valList.get(valList.size()-1));
		}
	}
}
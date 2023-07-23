package algorithm2022.nov;

/* n*n �ܾ� ���� �ȿ� K������ �ܾ ��� �� �� �ִ� ĭ
 * ���̵� : 1�� ĭ�� �Լ��� ������ ���� ĭ�� �Ǻ��Ͽ� 2ĭ�̻��̸� �� ���� ���ÿ� ����
 * ���̵��: ���η� �ѹ� Ž��, ���η� �ѹ� Ž��
 * �ð����⵵: O(2n)
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			ArrayList<ArrayList<Integer>> puzzle = new ArrayList<>();
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			for (int j = 0; j < N; j++) {
				ArrayList<Integer> arr = new ArrayList<>();
				for (String str : br.readLine().split(" ")) {
					arr.add(Integer.parseInt(str));
				}
				puzzle.add(arr);
			}
			ArrayList<Integer> width = new ArrayList<>();
			ArrayList<Integer> vertical = new ArrayList<>();
			for(int j = 0;j<N;j++) {
				int cnt = 0;
				for(int k =0;k<N;k++) {
					if(puzzle.get(j).get(k)==1) {
						cnt++;
						if(k==(N-1)) {
							width.add(cnt);
						}
					}else {
						if(cnt!=0) {
							width.add(cnt);
							cnt = 0;
						}
					}
				}
				
			}
			for(int j = 0;j<N;j++) {
				int cnt = 0;
				for(int k =0;k<N;k++) {
					if(puzzle.get(k).get(j)==1) {
						cnt++;
						if(k==(N-1)) {
							vertical.add(cnt);
						}
					}else {
						if(cnt!=0) {
							vertical.add(cnt);
							cnt = 0;
						}
					}
				}
			}
			int ans = 0;
			for(int item: width) {
				if(item==K) {
					ans++;
				}
			}
			for(int item: vertical) {
				if(item==K) {
					ans++;
				}
			}
			System.out.println("#"+(i+1)+" "+ans);
		}
	}
}
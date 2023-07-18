package dec_2022;

/* ���� Ȥ�� ȸ���� ���� ���� ���ϱ�
 * ���̵� : �ǹ�3
 * ���̵��: i+2��°�� ���� ������ ������ ���� �ﰢ��.
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			list.add(arr);
		}
		int[] cnt = new int[5];
		Arrays.fill(cnt, 0);

		for (int i = 0; i < 6; i++) {
			String s[] = br.readLine().split(" ");
			int dir = Integer.parseInt(s[0]);
			int len = Integer.parseInt(s[1]);
			list.get(i).add(dir);
			list.get(i).add(len);
			cnt[dir]++;
		}

		ArrayList<Integer> big = new ArrayList<>();
		ArrayList<Integer> small = new ArrayList<>();
		int smallS = 0;
		for (int i = 0; i < 6; i++) {
			if (cnt[list.get(i).get(0)] == 1) {
				big.add(list.get(i).get(1));
			}
			else {
				int n = list.get(i).get(0);
				//System.out.println(n);
				if(list.get((i+2)%6).get(0)==n) {
					if(list.get((i+1)%6).get(0)==list.get((i+3)%6).get(0)) {
						smallS = list.get((i+1)%6).get(1)*list.get((i+2)%6).get(1);
					}
					//System.out.println(smallS);
				}
			}
		}

		int S = big.get(0) * big.get(1) - smallS;
		System.out.println(S * K);
	}
}
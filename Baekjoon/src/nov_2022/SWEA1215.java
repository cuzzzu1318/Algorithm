package nov_2022;

/*N*N����� ȸ�� ã��aq
 * ���̵� : D3
 * ���̵��: ��
 * �ð����⵵:a
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int n = 0; n < 10; n++) {
			int L = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Character>> puzzle = new ArrayList<>();
			for (int i = 0; i < 8; i++) {
				ArrayList<Character> arr = new ArrayList<>();
				char[] s = br.readLine().toCharArray();
				for (char c : s) {
					arr.add(c);
				}
				puzzle.add(arr);
			}
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-L; j++) {
					boolean P = true;
					for (int k = 0; k < (L - (L / 2)); k++) {
						if (puzzle.get(i).get(j+k) != puzzle.get(i).get(j + L - k - 1)) {
							/*System.out.println(puzzle.get(i).get(j+k)+" "+puzzle.get(i).get(j + L - k - 1));
							System.out.println("i: "+i+" j: "+j);
							System.out.println((j+k)+","+(j + L - k - 1));*/
							P = false;
						}
					}
					if (P == true) {
						cnt++;
					}
				}
			}for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8-L; j++) {
					boolean P = true;
					for (int k = 0; k < (L - (L / 2)); k++) {
						if (puzzle.get(j+k).get(i) != puzzle.get(j + L - k - 1).get(i)) {
							/*System.out.println(puzzle.get(i).get(j+k)+" "+puzzle.get(i).get(j + L - k - 1));
							System.out.println("i: "+i+" j: "+j);
							System.out.println((j+k)+","+(j + L - k - 1));*/
							P = false;
						}
					}
					if (P == true) {
						cnt++;
					}
				}
			}
			System.out.println("#" + (n + 1) + " " + cnt);
		}

	}
}
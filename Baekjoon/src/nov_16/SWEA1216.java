package nov_16;

/* 문자 판 중에 가장 길이가 긴 회문의 길이 출력
 * 난이도 : D3
 * 아이디어: 
 * 시간복잡도:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1216 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Character>> puzzle = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				ArrayList<Character> arr = new ArrayList<>();
				char[] s = br.readLine().toCharArray();
				for (char c : s) {
					arr.add(c);
				}
				puzzle.add(arr);
			}
			int cnt = 0;
			int max = 0;
			for(int L = 1;L<100;L++) {
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100-L; j++) {
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
							if(L>max) {
								max=L;
							}
							cnt++;
						}
					}
				}for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100-L; j++) {
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
							if(L>max) {
								max=L;
							}
							cnt++;
						}
					}
				}
			}
				
			System.out.println("#" + t + " " + max);
		}
	}
}
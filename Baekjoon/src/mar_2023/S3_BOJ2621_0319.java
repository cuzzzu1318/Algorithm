package mar_2023;

/*  카드게임
 * 난이도 : 실버 3
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 13:05~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

class card {
	char[] cardColor = { 'R', 'B', 'Y', 'G' };
	int[] cardNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int[] freqColor = new int[4];
	int[] freqNum = new int[9];
	char[] color = new char[5];
	int[] num = new int[5];
	int max = 0;

	void addCard(String[] s, int i) {
		color[i] = s[0].charAt(0);
		for (int j = 0; j < 4; j++) {
			if (color[i] == cardColor[j]) {
				freqColor[j]++;
			}
		}
		num[i] = Integer.parseInt(s[1]);
		if (num[i] > max) {
			max = num[i];
		}
		for (int j = 0; j < 9; j++) {
			if (num[i] == cardNum[j]) {
				freqNum[j]++;
			}
		}
	}

	void numSort() {
		Arrays.sort(num);
	}

	int retAns() {
		if (isSameColor()) {
			if (isCont()) {
				return 900 + max;
				// rule 1
			} else {
				return 600 + max;
				// rule 4
			}
		} else {
			if (isCont()) {
				return 500 + max;
				// rule 5
			} else {
				for (int i = 0; i < 9; i++) {
					if (freqNum[i] == 4) {
						return 800 + cardNum[i];
						// rule 2
					}else if(freqNum[i]==3) {
						int num = cardNum[i];
						for (int j = 0; j < 9; j++) {
							if (i != j && freqNum[j] == 2) {
								return 10 * num + cardNum[j] + 700;
								// rule 3
							}
						}
						return 400+num;
						//rule 6
					} else if (freqNum[i] == 2) {
						int num = cardNum[i];
						for (int j = 0; j < 9; j++) {
							if (i != j && freqNum[j] == 2) {
								return 10 * Math.max(num, cardNum[j]) + Math.min(num, cardNum[j]) + 300;
								// rule 7
							}else if(i!=j&&freqNum[j]==3) {
								return 10*cardNum[j]+num+700;
								//rule 3
							}
						}
						return num + 200;
						// rule 8
					}
				}
			}
		}
		return 100 + max;
		// rule 9
	}

	boolean isSameColor() {
		for (int i = 0; i < 4; i++) {
			if (freqColor[i] == 5) {
				return true;
			}
		}
		return false;
	}

	boolean isCont() {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			if (num[i] + 1 == num[i + 1]) {
				cnt++;
			}
		}
		if (cnt == 4) {
			return true;
		}
		return false;
	}

}

public class S3_BOJ2621_0319 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] color = new char[5];
		int[] num = new int[5];
		card card = new card();
		for (int i = 0; i < 5; i++) {
			String[] s = br.readLine().split(" ");
			card.addCard(s, i);
		}
		card.numSort();
		bw.write(Integer.toString(card.retAns()));
		bw.flush();
		bw.close();

	}
}
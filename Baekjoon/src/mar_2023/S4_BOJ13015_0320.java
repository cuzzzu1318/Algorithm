package mar_2023;

/*  별 찍기
 * 난이도 : 실버 4
 * 아이디어: 재귀 노가다 
 * 			이게 맞나 싶음 ㅎㅎ
 * 시간복잡도:
 * 소요 시간: 20:13 ~ 20:47 (34min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S4_BOJ13015_0320 {

	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void makeStar(int d) throws IOException {
		String stars = "";
		for (int i = 0; i < N - d; i++) {
			stars += " ";
		}
		stars += "*";

		if (d == N) {
			for (int i = 2; i < N; i++) {
				stars += "*";
			}
		} else {
			for (int i = 2; i < N; i++) {
				stars += " ";
			}
		}
		stars += "*";
		if (d == 1) {
			for (int i = 2; i < N; i++) {
				stars += " ";
			}
			stars+="*";
			bw.write(stars + "\n");
			return;
		}
		stars+=" ";
		for(int i = 2;i<d;i++) {
			stars+="  ";
		}
		stars+="*";
		if (d == N) {
			for (int i = 2; i < N; i++) {
				stars += "*";
			}
		} else {
			for (int i = 2; i < N; i++) {
				stars += " ";
			}
		}
		stars += "*";
		bw.write(stars + "\n");
		makeStar(d - 1);
		bw.write(stars + "\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		makeStar(N);
		bw.flush();
		bw.close();
	}
}
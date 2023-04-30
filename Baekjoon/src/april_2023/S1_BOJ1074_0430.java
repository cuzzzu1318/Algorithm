package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S1_BOJ1074_0430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);

		int n = (int) Math.pow(2, N);
		//배열의 최댓값 +1

		int[] row = { 0, n };
		int[] column = { 0, n };
		//행, 열의 최소, 최댓값
		int min = 0;
		int max= n*n-1;
		//실제 최소, 최댓값
		while (min<max) {
			int rm = (row[0] + row[1]) / 2;
			int cm = (column[0] + column[1]) / 2;
			int middle = (min+max)/2;
			//행, 열의 중간 인덱스와 값의 중간값
			if (r < rm) {
				//행이 중간보다 위라면
				row[1] = rm;
				max = middle;
				middle = (min+max)/2;
				//값을 설정해주고
				if (c < cm) {
					//열이 중간보다 왼쪽이라면
					column[1] = cm;
					max = middle;
				} else {
					//열이 중간보다 오른쪽이라면
					column[0] = cm+1;
					min = middle+1;
				}
			} else {
				//행이 중간보다 아래라면
				row[0] = rm+1;
				min = middle+1;
				middle = (min+max)/2;
				if (c < cm) {
					//열이 중간보다 왼쪽이라면
					column[1] = cm;
					max = middle;
					
				} else {
					//열이 중간보다 오른쪽이라면
					min = middle+1;
					column[0] = cm+1;
				}
			}
		}
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();

	}
}
package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ9461_0430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Long> p = new ArrayList<>();
			p.add((long) 1);
			p.add((long) 1);
			p.add((long) 1);
			p.add((long) 2);
			p.add((long) 2);
			//ó�� 5�� �Է�
			for (int i = 5; i < N; i++) {
				//i-5��°�� i-1��°�� ���� ���
				p.add(p.get(i - 5) + p.get(i - 1));
			}
			bw.write(Long.toString(p.get(N-1)) + "\n");
		}

		bw.flush();
		bw.close();

	}
}
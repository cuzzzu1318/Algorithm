package mar_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class S {
	int num = 0;
	ArrayList<String> arr = new ArrayList<>();
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	S(BufferedWriter bw) {
		this.bw = bw;
	}

	void func(String s, int x) throws IOException {

		// System.out.println(s+" "+x);
		if (s.equals("add")) {
			add(x);
		} else if (s.equals("remove")) {
			remove(x);
		} else if (s.equals("check")) {
			check(x);
		} else if (s.equals("toggle")) {
			toggle(x);
		} else if (s.equals("all")) {
			this.all();
		} else if (s.equals("empty")) {
			empty();
		}
	}

	private void add(int x) {
		num = num | (1 << x);
	}

	private void remove(int x) {
		num &= ~(1 << x);
	}

	private void check(int x) throws IOException {
		bw.write(((num >> x) & 1) + "\n");
	}

	private void toggle(int x) {
		num ^= (1 << x);
	}

	private void all() {
		num = -1;
	}

	private void empty() {
		num = 0;
	}

}

public class BOJ11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		S s1 = new S(bw);
		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			if (s.length == 1) {
				s1.func(s[0], 0);
				continue;
			}
			s1.func(s[0], Integer.parseInt(s[1]));
		}
		bw.flush();
		bw.close();
	}
}
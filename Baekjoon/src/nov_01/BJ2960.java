package nov_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ2960 {

	static boolean isPrime(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> removed = new LinkedList<>();

		for (int i = 2; i <= N; i++) {
			list.add(i);
		}

		for (int i : list) {
			if (cnt == K) {
				break;
			}
			if (isPrime(i)) {
				for (int j : list) {
					if (j % i == 0&&!removed.contains(j)) {
						removed.add(j);
						cnt++;
						if (cnt == K) {
							System.out.println(j);
							break;
						}
					}
				}
			}
		}

	}
}

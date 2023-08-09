package algorithm2023.aug.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18258_큐2 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	static int s, e;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = 0;
		e = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			func(st);

		}
		System.out.println(sb);

	}

	static void func(StringTokenizer st) {
		String func = st.nextToken();
		switch (func) {
		case "push":
			int X = Integer.parseInt(st.nextToken());
			list.add(X);
			e++;
			break;
		case "pop":
			if (s <= e) {
				sb.append(list.get(s++)).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			break;
		case "size":
			sb.append(e - s + 1).append("\n");
			break;
		case "empty":
			if (s > e)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
			break;
		case "front":
			if (s <= e) {
				sb.append(list.get(s)).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			break;
		case "back":
			if (s <= e) {
				sb.append(list.get(e)).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
			break;
		}
	}
}

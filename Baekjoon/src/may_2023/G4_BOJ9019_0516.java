package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_BOJ9019_0516 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Queue<String> v = new LinkedList<>();
			ArrayList<Integer> visit = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			v.add("");
			visit.add(A);
			loop:
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int n = q.poll();
					String func = v.poll();
					if(n==B) {
						sb.append(func+"\n");
						break loop;
					}
					for (int i = 0; i < 4; i++) {
						int next = 0;
						String nextF = func;
						switch (i) {
						case 0:
							next = n * 2 % 10000;
							nextF+="D";
							break;
						case 1:
							next = n - 1;
							if (n== 0) {
								next = 9999;
							}
							nextF+="S";
							break;
						case 2:
							next = ((n * 10)%10000+n/1000);
							nextF+="L";
							break;
						default:
							next = n / 10 + (n % 10) * 1000;
							nextF+="R";
						}
						if (!visit.contains(next)) {
							q.add(next);
							visit.add(next);
							v.add(nextF);
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
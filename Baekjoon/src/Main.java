
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		int cnt = 1;
		sb.append("<");
		while (q.size()>1) {
			if (cnt == K) {
				sb.append(q.poll()+", ");
				cnt = 1;
			} else {
				q.add(q.poll());
				cnt++;
			}
		}
		sb.append(q.poll()+">");
		System.out.println(sb);

	}

}
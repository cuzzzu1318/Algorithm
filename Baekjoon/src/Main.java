import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int bacon;
	static boolean[] visited;
	static boolean[][] table;
	static int min;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		table = new boolean[N][N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;

			table[A][B] = true;
			table[B][A] = true;
		}
		for (int i = 0; i < N; i++) {
			bacon = 0;
			visited = new boolean[N];
			bfs(i);
		}
		System.out.println(ans + 1);
	}

	public static void bfs(int num) {
		Queue<boolean[]> q = new LinkedList<>();
		q.add(table[num]);
		visited[num] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				boolean[] A = q.poll();
				for (int j= 0; j< A.length; j++) {
					if (A[j] && !visited[j]) {
						bacon+=cnt;
						visited[j] = true;
						q.add(table[j]);
					}
				}
			}
			cnt++;

		}
		if (min > bacon) {
			min = bacon;
			ans = num;
		}

	}
}
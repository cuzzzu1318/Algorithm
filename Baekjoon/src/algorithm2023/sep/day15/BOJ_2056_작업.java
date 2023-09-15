package algorithm2023.sep.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 각 작업별로 완료되는 시간을 저장
 * 가장 긴 시간이 최종적으로 끝나는 시간이므로 정답
 */

public class BOJ_2056_작업 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, time[], indegree[];
	static ArrayList<ArrayList<Integer>> prior = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		time = new int[N + 1];
		indegree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			prior.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t; // i번째 작업을 하기 위해 필요한 시간 t
			int n = Integer.parseInt(st.nextToken());
			indegree[i] = n; // i번째 작업을 하기 위해 필요한 선행 작업의 수 n
			for (int j = 0; j < n; j++) {
				// 선행작업들에게 다음 작업을 저장해줌.
				int cond = Integer.parseInt(st.nextToken());
				prior.get(cond).add(i);
			}
		}

		// 위상정렬을 위한 큐
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			// 선행조건이 없는 작업을 먼저 큐에 삽입
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		// 최종적으로 걸리는 시간을 저장할 배열
		int ans[] = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			ans[i] = time[i];
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < prior.get(cur).size(); j++) {
				//현재 진행중인 작업의 다음 작업 시간 갱신 -> 선행작업이 모두 왼료되어야 진행할 수 있으므로 선행작업 중 가장 오래걸리는 시간으로 갱신됨.
				ans[prior.get(cur).get(j)] = Math.max(ans[prior.get(cur).get(j)],
						ans[cur] + time[prior.get(cur).get(j)]);
				//다음 작업의 선행작업이 모두 완료되었다면 큐에 삽입
				if (--indegree[prior.get(cur).get(j)] == 0) {
					q.add(prior.get(cur).get(j));
				}
			}

		}
		//가장 긴 시간을 출력하기 위해 정렬
		Arrays.sort(ans);
		System.out.println(ans[N]);
	}
}

package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_BOJ1697_0504 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//수빈이의 위치 N, 동생의 위치 k
		Queue<Integer> q = new LinkedList<>();
		//BFS에 사용될 큐
		boolean[] v = new boolean[100001];
		//이미 탐색한 위치를 기록하기 위한 배열
		q.add(N);
		int cnt = 0;
		loop:
		while (!q.isEmpty()) {
			//BFS
			int size = q.size();
			for (int l = 0; l < size; l++) {
				//초 단위로 끊기 위해 level을 알기 위한 반복문 추가
				int n = q.poll();
				if (v[n]) {
					continue;
				}
				if(n==K) {
					//K를 찾으면 while문 종료
					break loop;
				}
				v[n] = true;
				int[] next = { n - 1, n + 1, n * 2 };
				//탐색할 위치 배열
				for (int i = 0; i < 3; i++) {
					if(next[i]>=0&&next[i]<=100000) {
						//0과 100000 사이에 있는 값만 탐색
						q.add(next[i]);
					}
					
				}
			}
			
			cnt++;
			//한번의 탐색을 마치면 1초 추가
		}
		System.out.println(cnt);
	}
}
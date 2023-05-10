package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class S1_BOJ11286_0510 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> {
			if (Math.abs(e1) < Math.abs(e2)) {
				//e1의 절댓값이 더 작다면 음수 반환
				return Math.abs(e1) - Math.abs(e2);
			} else if (Math.abs(e1) == Math.abs(e2)) {
				//절댓값이 같다면 크기를 비교
				return e1-e2;
			} else {
				//절댓값이 크다면 양수 반환
				return 1;
			}
		});
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				//0이면
				if (q.isEmpty()) {
					//큐가 비었다면 0 출력
					sb.append("0\n");
				} else {
					//원소가 있다면 해당 원소 출력 후 삭제
					sb.append(q.poll() + "\n");
				}
			} else {
				//0이 아니면 n을 큐에 추가
				q.add(n);
			}
		}
		System.out.println(sb);
	}
}
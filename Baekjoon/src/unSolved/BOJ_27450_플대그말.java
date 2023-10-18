package unSolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_27450_플대그말 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	static int p[], t[],sum[];

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		p = new int[N+1];
		t = new int[N+1];
		sum = new int[N +1];
        int[] additionalPower = new int[N+1];
        ArrayDeque<Integer> speech = new ArrayDeque<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
        long shout = 0;
        int effectiveShout = 0;

        for (int i = 1; i <= N; i++) {
            // 이전에 더해진 shout 값에서 effectiveShout을 뺀 값을 additionalPower에 저장
            additionalPower[i] = additionalPower[i - 1] - effectiveShout;

            // p[i]에 additionalPower[i]를 더함
            p[i] += additionalPower[i];

            // count 계산
            int count = (t[i] <= p[i]) ? 0 : (t[i] - p[i]) / K + (((t[i] - p[i]) % K== 0) ? 0 : 1);

            // shout 값과 effectiveShout 값을 업데이트
            shout += count;
            effectiveShout += count;

            // speech 큐에 count 값을 추가
            speech.add(count);

            // additionalPower[i]와 p[i] 값을 업데이트
            additionalPower[i] += (count * K);
            p[i] += additionalPower[i];

            // speech 큐에서 첫 번째 값을 제거하고 effectiveShout에서 빼기
            effectiveShout -= speech.poll();
        }

        // 최종 shout 값 출력
        System.out.println(shout);
		
		
		
	}
}

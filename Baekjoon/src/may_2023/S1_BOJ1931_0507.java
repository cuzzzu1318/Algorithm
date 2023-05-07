package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_BOJ1931_0507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			// 회의의 시작시간 s와 끝나는 시간 e
			time[i][0] = s;
			time[i][1] = e;
			
		}
		Arrays.sort(time, (e1,e2)-> {
			//정렬
			if(e1[1]==e2[1]) {
				//종료 시점이 같은 경우 시작 시점을 오름차 순으로 정렬
				return e1[0]-e2[0];
			}else {
				return e1[1]-e2[1];
			}
		});
		
		int cnt = 0;
		int end = 0;
		for(int i= 0;i<N;i++) {
			if(end<=time[i][0]) {
				//기록된 종료시점 이후에 시작되는 회의의 경우 카운트하고 종료시점 갱신
				cnt++;
				end = time[i][1];
			}
		}
		System.out.println(cnt);
		
		
	}
}
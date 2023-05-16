package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_BOJ16928_0516 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		// 사다리의 수 N
		int M = Integer.parseInt(st.nextToken());
		// 뱀의 수 M
		int[] board = new int[101];
		
		
		for(int i= 1;i<=100;i++) {
			board[i] = i;
		}
		//각 칸을 인덱스로 초기화
		
		for(int i = 0;i<N;i++) {
			//사다리
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
			//사다리의 출발점과 도착지 연결
		}
		for(int i = 0;i<M;i++) {
			//뱀
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
			//뱀 출발지와 도착지 연결
		}
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(1);
		int[] v = new int[101];
		while(!bfs.isEmpty()) {
			//BFS
			int n = bfs.poll();
			for(int i = 1;i<=6;i++) {
				//주사위 1부터 6까지 굴렸을 때
				int next = n+i;
				//다음 목적지
				if(next>100) {
					//100을 넘어서면 움직일 수 없으므로 continue
					continue;
				}
				if(v[board[next]]==0) {
					//목적지의 주사위 횟수 정보가 없을 때
					bfs.offer(board[next]);
					//큐에 추가 후 목적지의 주사위 정보는 현재 지점 +1
					v[board[next]] = v[n]+1;
				}
				
			}
		}
		
		
		
		System.out.println(v[100]);
	}
}
package algorithm2023.aug.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
	static int N, M, input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//각 노드의 연결 정보를 담은 리스트
		LinkedList<Integer>[] graph = new LinkedList[N];
		for(int i= 0;i<N;i++) {
			graph[i] = new LinkedList<>();
		}
		
		//각 노드의 이전노드 개수
		input = new int[N];
		
		//위상정렬에 사용할 큐, 쉬운 문제부터 풀기 위해 우선순위 큐 사용
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		//입력을 받으며 그래프 연결 및 이전노드 개수 기록
		for(int i= 0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b);
			input[b]++;
		}
		
		//이전 노드가 없다 -> 현재 순서에 올 수 있는 노드이므로 큐에 삽입
		for(int i= 0;i<N;i++) {
			if(input[i]==0) {
				pq.add(i);
			}
		}
		//최종적으로 N개의 노드를 기록할 것이므로 N번 반복
		for(int i=0;i<N;i++) {
			int cur= pq.poll();
			//문제 번호는 1부터 시작이므로 +1한 값 출력
			sb.append(cur+1).append(" ");
			//cur와 연결된 노드 중 이전노드 값을 갱신했을 때 0이 되는 노드 큐에 삽입
			for(int j : graph[cur]) {
				if(--input[j]==0)pq.offer(j);
			}
		}
		System.out.println(sb);
	}
}
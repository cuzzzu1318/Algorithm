package algorithm2023.may;

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
		// ��ٸ��� �� N
		int M = Integer.parseInt(st.nextToken());
		// ���� �� M
		int[] board = new int[101];
		
		
		for(int i= 1;i<=100;i++) {
			board[i] = i;
		}
		//�� ĭ�� �ε����� �ʱ�ȭ
		
		for(int i = 0;i<N;i++) {
			//��ٸ�
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
			//��ٸ��� ������� ������ ����
		}
		for(int i = 0;i<M;i++) {
			//��
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
			//�� ������� ������ ����
		}
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(1);
		int[] v = new int[101];
		while(!bfs.isEmpty()) {
			//BFS
			int n = bfs.poll();
			for(int i = 1;i<=6;i++) {
				//�ֻ��� 1���� 6���� ������ ��
				int next = n+i;
				//���� ������
				if(next>100) {
					//100�� �Ѿ�� ������ �� �����Ƿ� continue
					continue;
				}
				if(v[board[next]]==0) {
					//�������� �ֻ��� Ƚ�� ������ ���� ��
					bfs.offer(board[next]);
					//ť�� �߰� �� �������� �ֻ��� ������ ���� ���� +1
					v[board[next]] = v[n]+1;
				}
				
			}
		}
		
		
		
		System.out.println(v[100]);
	}
}
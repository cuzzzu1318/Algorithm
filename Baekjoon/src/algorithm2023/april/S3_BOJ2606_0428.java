package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ2606_0428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] d;
	static int cnt =0 ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		//��� ���� ���� �� ��
		boolean[][] graph =  new boolean[N+1][N+1];
		//�ε����� ���� ���ϵ��� �е��۾��� �� �׷���
		d = new boolean[N+1];
		//������ ��� ���
		for (int i = 0; i < T; i++) {
			
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph[a][b] = true;
			graph[b][a] = true;
			//���ʿ� ����
		}
		count(graph, 1);
		//ī��Ʈ
		bw.write(Integer.toString(cnt-1));
		bw.flush();
		bw.close();
		
	}
	
	static void count(boolean[][] graph, int n) {
		if(d[n]) {
			//�̹� Ž���ߴٸ� ����
			return;
		}else {
			//Ž������ �ʾҴٸ�
			d[n] =true;
			//Ž���ߴٰ� ����ϰ� count
			cnt++;
			for(int i = 1;i<graph[n].length;i++) {
				//����� ��带 ��� Ž��
				if(graph[n][i]) {
					count(graph, i);
				}
			}
		}
	}
	
	
}
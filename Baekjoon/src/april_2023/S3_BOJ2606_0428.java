package april_2023;

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
		//노드 수와 연결 쌍 수
		boolean[][] graph =  new boolean[N+1][N+1];
		//인덱스를 보기 편하도록 패딩작업을 한 그래프
		d = new boolean[N+1];
		//접근한 노드 기록
		for (int i = 0; i < T; i++) {
			
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			graph[a][b] = true;
			graph[b][a] = true;
			//양쪽에 연결
		}
		count(graph, 1);
		//카운트
		bw.write(Integer.toString(cnt-1));
		bw.flush();
		bw.close();
		
	}
	
	static void count(boolean[][] graph, int n) {
		if(d[n]) {
			//이미 탐색했다면 리턴
			return;
		}else {
			//탐색하지 않았다면
			d[n] =true;
			//탐색했다고 기록하고 count
			cnt++;
			for(int i = 1;i<graph[n].length;i++) {
				//연결된 노드를 모두 탐색
				if(graph[n][i]) {
					count(graph, i);
				}
			}
		}
	}
	
	
}
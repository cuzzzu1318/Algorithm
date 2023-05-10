package may_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_BOJ11403_0510 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws NumberFormatException, IOException {
	   int N = Integer.parseInt(br.readLine());
	   boolean[][] g = new boolean[N][N];
	   //그래프 연결 정보를 저장할 배열
	   for(int i =0;i<N;i++) {
		   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		   for(int j = 0;j<N;j++) {
			   if(st.nextToken().equals("1")) {
				   //입력 값이 1이면 해당 노드로 연결되어있다고 기록
				   g[i][j] = true;;
			   }
		   }
	   }
	   
	   for(int i =0 ;i<N;i++) {
		   //모든 노드에 대해 bfs 진행
		   Queue<Integer> q = new LinkedList<>();
		   q.add(i);
		   boolean[] v = new boolean[N];
		   boolean isFirst  = true;
		   //첫번째 노드는 방문기록이 되면 안되므로 첫번째노드를 표시하는 변수
		   while(!q.isEmpty()) {
			   //bfs
			   int n = q.poll();
			   if(isFirst) {
				   //첫번째노드이면 방문배열에 기록하지 않고 진행
				   isFirst = false;
			   }else {
				   v[n] = true;
			   }
			   for(int j = 0;j<N;j++) {
				   if(!v[j]&&g[n][j]) {
					   q.add(j);
				   }
			   }
		   }
		   for(int j = 0;j<N;j++) {
			   //방문배열을 순회하며 방문한 경우에는 연결된 것이므로 1, 아니면 0 출력
			   if(v[j]) {
				   sb.append(1+" ");
			   }else {
				   sb.append(0+" ");
			   }
		   }
		   
		   sb.append("\n");
	   }
	   
	   System.out.println(sb);
   }
}
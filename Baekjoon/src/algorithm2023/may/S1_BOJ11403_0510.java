package algorithm2023.may;

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
	   //�׷��� ���� ������ ������ �迭
	   for(int i =0;i<N;i++) {
		   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		   for(int j = 0;j<N;j++) {
			   if(st.nextToken().equals("1")) {
				   //�Է� ���� 1�̸� �ش� ���� ����Ǿ��ִٰ� ���
				   g[i][j] = true;;
			   }
		   }
	   }
	   
	   for(int i =0 ;i<N;i++) {
		   //��� ��忡 ���� bfs ����
		   Queue<Integer> q = new LinkedList<>();
		   q.add(i);
		   boolean[] v = new boolean[N];
		   boolean isFirst  = true;
		   //ù��° ���� �湮����� �Ǹ� �ȵǹǷ� ù��°��带 ǥ���ϴ� ����
		   while(!q.isEmpty()) {
			   //bfs
			   int n = q.poll();
			   if(isFirst) {
				   //ù��°����̸� �湮�迭�� ������� �ʰ� ����
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
			   //�湮�迭�� ��ȸ�ϸ� �湮�� ��쿡�� ����� ���̹Ƿ� 1, �ƴϸ� 0 ���
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
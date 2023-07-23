package algorithm2023.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S1_BOJ2667_0508 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();
   static int[][] map;
   static boolean[][] v;
   static int[] dx = {-1,0,1,0};
   static int[] dy = {0,1,0,-1};
   //���⺤��
   static int cnt = 0;
   //������ ��
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	  int N = Integer.parseInt(br.readLine());
	  map = new int[N+2][N+2];
	  v = new boolean[N+2][N+2];
	  //������ �湮�迭, �е��۾��� ���� 2�� ������
	  for(int i = 1;i<=N;i++) {
		  String[] s = br.readLine().split("");
		  for(int j = 1;j<=N;j++) {
			  map[i][j] = Integer.parseInt(s[j-1]);
		  }
	  }
	  
	  ArrayList<Integer> house = new ArrayList<>();
	  //���� �� ���� ������ ����� �迭
	  
	  for(int i = 1;i<=N;i++) {
		  for(int j = 1;j<=N;j++) {
			  if(map[i][j]==1&&!v[i][j]) {
				  //���� �ְ� �湮���� �ʾ��� �� dfs ���� -> �� ������ �ѹ��� ����ǹǷ� cnt++
				 house.add(dfs(i,j));
				 //���� �� ���� ���� ����
				  cnt++;
			  }
		  }
	  }
	  Collections.sort(house);
	  //�� ���� �������� ����
	  sb.append(cnt+"\n");
	  for(int n : house) {
		  sb.append(n+"\n");
	  }
	  System.out.println(sb);
           
   }
   
   static int dfs(int x, int y) {
	   int cnt = 1;
	   if(v[x][y]) {
		   return 0;
	   }
	   v[x][y] = true;
	   for(int i =0;i<4;i++) {
		   int nextX = x+dx[i];
		   int nextY = y+dy[i];
		   if(map[nextX][nextY]==1) {
			  cnt+= dfs(nextX, nextY);
		   }
	   }
	   return cnt;
   }
   
}
package may_2023;

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
   //방향벡터
   static int cnt = 0;
   //단지의 수
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	  int N = Integer.parseInt(br.readLine());
	  map = new int[N+2][N+2];
	  v = new boolean[N+2][N+2];
	  //지도와 방문배열, 패딩작업을 위해 2를 더해줌
	  for(int i = 1;i<=N;i++) {
		  String[] s = br.readLine().split("");
		  for(int j = 1;j<=N;j++) {
			  map[i][j] = Integer.parseInt(s[j-1]);
		  }
	  }
	  
	  ArrayList<Integer> house = new ArrayList<>();
	  //단지 별 집의 개수가 저장될 배열
	  
	  for(int i = 1;i<=N;i++) {
		  for(int j = 1;j<=N;j++) {
			  if(map[i][j]==1&&!v[i][j]) {
				  //집이 있고 방문하지 않았을 때 dfs 실행 -> 한 단지는 한번만 실행되므로 cnt++
				 house.add(dfs(i,j));
				 //단지 내 집의 수를 저장
				  cnt++;
			  }
		  }
	  }
	  Collections.sort(house);
	  //집 수를 오름차순 정렬
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
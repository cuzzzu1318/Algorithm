package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2_BOJ1012_0430 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static StringBuilder sb = new StringBuilder();
   static int cnt = 0;
   static boolean[][] v ;
   static int[] dx = {-1,0,1,0};
   static int[] dy = {0,1,0,-1};
   
   static int M;
   static int N;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	   int T = Integer.parseInt(br.readLine());
	   for(int t = 0;t<T;t++) {
		   cnt=0;
		   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		   M = Integer.parseInt(st.nextToken());
		   N = Integer.parseInt(st.nextToken());
		   int K = Integer.parseInt(st.nextToken());
		   //배추밭의 가로 길이 M
		   //배추밭의 세로 길이 N
		   //배추가 심어져있는 위치의 개수
		   
		   boolean[][] field = new boolean[M][N];
		   v = new boolean[M][N];
		   
		   int[][] xy = new int[K][2];
		   for(int i= 0;i<K;i++) {
			   st = new StringTokenizer(br.readLine(), " ");
			   int x = Integer.parseInt(st.nextToken());
			   int y = Integer.parseInt(st.nextToken());
			   xy[i][0] =x;
			   xy[i][1] =y;
			   field[x][y] = true;
		   }
		   for(int i = 0;i<K;i++) {
			   if(!v[xy[i][0]][xy[i][1]]) {
				   dfs(field, xy[i][0], xy[i][1]);
				   cnt++;
			   }
		   }
		   sb.append(cnt+"\n");
	   }
	   System.out.println(sb);
   }
   
   static void dfs(boolean[][] field, int x, int y) {
	   if(v[x][y]) {
		   return;
	   }else {
		   v[x][y] = true;
		   if(!field[x][y]) {
			   return;
		   }
		   for(int i =0;i<4;i++) {
			   int curX = x+dx[i];
			   int curY = y+dy[i];
			   if(check(curX, curY)) {
				   dfs(field, curX, curY);
			   }
		   }
	   }
   }
   
   static boolean check(int x, int y) {
	   if(x<0||y<0||x>=M||y>=N) {
		   return false;
	   }else {
		   return true;
	   }
   }
}
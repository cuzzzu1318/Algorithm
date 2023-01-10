package jan_05_2023;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ14500{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int M = Integer.parseInt(s[1]);
      int[][] map = new int[N][M];
      for(int i = 0;i<N;i++) {
    	  s = br.readLine().split(" ");
    	  for(int j = 0;j<M;j++) {
    		  map[i][j] = Integer.parseInt(s[j]);
    	  }
      }
      
      int sum = 0;
      for(int i = 0;i<N-1;i++) {
    	  for(int j = 0;j<M-1;j++) {
    		  
    		  sum = Math.max(sum, map[i][j]+map[i][j+1]+map[i+1][j]+map[i+1][j+1]);
    		  
    		  if(j>=0&&j<M-2) {
    			  sum = Math.max(sum, map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2]);
    		  }
    		  if(j>0&&j<M) {
    			  sum = Math.max(sum, map[i][j]+map[i][j+1]+map[i+1][j-1]+map[i+1][j]);
    		  }
    	  }
      }
      
      for(int i = 0;i<N-1;i++) {
    	  for(int j =0;j<M-1;j++) {
    		//  System.out.println(i+" "+j);
    		  if(i>=0&&i<N-2) {
    			  sum = Math.max(sum, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1]);
    		  }
    		  if(i>0&&i<N) {
    			  sum = Math.max(sum, map[i][j]+map[i+1][j]+map[i][j+1]+map[i-1][j+1]);
    		  }
    	  }
      }
      
      for(int i = 0;i<N;i++) {
    	  for(int j = 0;j<M-2;j++) {
    		  int n = map[i][j]+map[i][j+1]+map[i][j+2];
    		  if(i>0) {
    			  for(int k = j;k<j+3;k++) {
    				  sum=Math.max(sum, n+map[i-1][k]);
    			  }
    		  }if(i<N-1) {
    			  for(int k = j;k<j+3;k++) {
    				  sum=Math.max(sum, n+map[i+1][k]);
    			  }
    		  }
    	  }
      }
      
      for(int i = 0;i<N-2;i++) {
    	  for(int j = 0;j<M;j++) {
    		  int n = map[i][j]+map[i+1][j]+map[i+2][j];
    		  if(j>0) {
    			  for(int k = i;k<i+3;k++) {
    				  sum=Math.max(sum, n+map[k][j-1]);
    			  }
    		  }if(j<M-1) {
    			  for(int k = i;k<i+3;k++) {
    				  sum=Math.max(sum, n+map[k][j+1]);
    			  }
    		  }
    	  }
      }
      
      for(int i =0;i<N;i++) {
    	  for(int j = 0;j<M-3;j++) {
    		  sum = Math.max(sum, map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3]);
    	  }
      }
      
      for(int i =0;i<N-3;i++) {
    	  for(int j = 0;j<M;j++) {
    		  sum = Math.max(sum, map[i+1][j]+map[i+2][j]+map[i][j]+map[i+3][j]);
    	  }
      }
      
      System.out.println(sum);
      
   }
}
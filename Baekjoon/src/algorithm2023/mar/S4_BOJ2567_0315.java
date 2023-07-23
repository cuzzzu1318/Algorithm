package algorithm2023.mar;

/*  100*100 ������ 10*10 �����̵��� ������ ���� �����̰� ���� ������ �ѷ��� ���϶�
 * �˻��ؼ� Ǯ����. �ٵ� ������ �����ߴ��ŷ� �ϴ���. bfs ���� ����� ������.
 * ���̵� : �ǹ� 4
 * ���̵��: ������ ä����� 1�� ä��� �ֺ��� 0�� ������ ���°ɷ�. �������� 2�� ������.
 * �ð����⵵:
 * �ҿ� �ð�: �� �ɸ� �� �νð� 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S4_BOJ2567_0315 {
	static int[] dx = {1,0,-1,0};
	static int[] dy =  {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int N = Integer.parseInt(br.readLine());
      int[][] paper = new int[102][102];
      for(int[] arr : paper) {
    	  Arrays.fill(arr, 0);
      }
      for(int i = 0;i<N;i++) {
    	  String[] s = br.readLine().split(" ");
    	  int x = Integer.parseInt(s[0]);
    	  int y = Integer.parseInt(s[1]);
    	  for(int j = x;j<x+10;j++) {
    		  for(int k = y;k<y+10;k++) {
    			  paper[j][k]=1;
    		  }
    	  }
      }
      int cnt = 0;
      
      
      
      
      for(int i = 1;i<101;i++) {
    	  for(int j = 1;j<101;j++) {
    		  if(paper[i][j]==1) {
    			  int count = 0;
    			  for(int n = 0;n<4;n++) {
    				  if(paper[i+dx[n]][j+dy[n]]==0) {
    					  count++;
    				  }
    			  }
    			  if(count==1) {
    				  cnt++;
    			  }else if(count==2) {
    				  cnt+=2;
    			  }
    			  
    		  }
    	  }
      }
      System.out.println(cnt);
   }
   
}
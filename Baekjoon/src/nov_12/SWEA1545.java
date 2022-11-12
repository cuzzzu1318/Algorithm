package nov_12;


/* 2차원 배열의 각 열, 행, 대각선의 합 중 가장 큰 값 출력
 * 난이도 : D3
 * 아이디어: 행의 개수만큼 반복하며 각 원소들을 각 열, 행 대각선의 합에 더해줌
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA1545{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t = 0; t<10;t++) {
    	  int[] rowMax = new int[100];
    	  Arrays.fill(rowMax, 0);
    	  int[] colMax = new int[100];
    	  Arrays.fill(colMax, 0);
    	  int[] diagMax = new int[2];
    	  Arrays.fill(diagMax, 0);
    	  int[][] arr = new int[100][100];
    	  int num = Integer.parseInt(br.readLine());
    	  for(int i = 0;i<100;i++) {
    		  String[] s = br.readLine().split(" ");
    		  for(int j = 0;j<100;j++) {
    			  arr[i][j] = Integer.parseInt(s[j]);
    		  }
    	  }
    	  int cnt = 99;
    	  for(int i = 0;i<100;i++) {
    		  for(int j = 0;j<100;j++) {
    			  rowMax[i]+=arr[i][j];
    			  colMax[j]+=arr[i][j];
    			  if(i==j) {
    				  diagMax[0]+=arr[i][j];
    			  }else if(j==cnt) {
    				  diagMax[1]+=arr[i][j];
    				  cnt--;
    			  }
    		  }
    	  }
    	  Arrays.sort(rowMax);
    	  Arrays.sort(colMax);
    	  Arrays.sort(diagMax);
    	  int[] ans = new int[3];
    	  ans[0] = rowMax[99];
    	  ans[1] = colMax[99];
    	  ans[2] = diagMax[1];
    	  Arrays.sort(ans);
    	  System.out.println("#"+num+" "+ans[2]);
    	  
      }
   }
}
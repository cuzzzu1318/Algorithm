package nov_17;

/* 거스름돈 갯수 출력
 * 난이도 : D2
 * 아이디어: 그리디
 * 시간복잡도:O(돈의 종류) 
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA1970{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      int[] mArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
      for(int t = 1; t<=T;t++) {
         int N = Integer.parseInt(br.readLine());
         int[] cnt = new int[8];
         Arrays.fill(cnt, 0);
         for(int i = 0; i<8;i++) {
        	 cnt[i]+=N/mArr[i];
        	 N%=mArr[i];
         }
         System.out.println("#"+t+" ");
         for(int item : cnt) {
        	 System.out.print(item+" ");
         }
         System.out.println("");
      }
   }
}
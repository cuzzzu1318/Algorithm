package nov_17;

/* 1부터N까지의 숫자에서 홀수는 더하고 짝수는 빼기
 * 난이도 : D2
 * 아이디어: N까지 탐색해서 %2==0 이면 더하기
 * 시간복잡도: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1986{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         int N = Integer.parseInt(br.readLine());
         int sum = 0;
         for(int i = 1;i<=N;i++) {
        	 if(i%2==0) {
        		 sum-=i;
        	 }else {
        		 sum+=i;
        	 }
         }
         System.out.println("#"+t+" "+sum);
      }
   }
}
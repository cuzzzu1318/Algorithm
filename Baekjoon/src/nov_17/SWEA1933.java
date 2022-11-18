package nov_17;

/* 정수 N의 약수를 오름차 순 출력
 * 난이도 : D1
 * 아이디어: 수가 작으니 나이브하게 계산
 * 시간복잡도:O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1933{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         if(T%t==0) {
        	 System.out.print(t+" ");
         }
      }
   }
}
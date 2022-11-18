package nov_18;

/* 월+일로 주어지는 입력 두개의 날짜 차이를 구하여라
 * 난이도 : D2
 * 아이디어: 월의 차 만큼 반복문 돌려서 해당 월의 날짜만큼 더함
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1948{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] s = br.readLine().split(" ");
         int m1 = Integer.parseInt(s[0]);
         int d1 = Integer.parseInt(s[1]);
         int m2 = Integer.parseInt(s[2]);
         int d2 = Integer.parseInt(s[3]);
         int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         int sum = 0;
         for(int i = m1+1;i<m2;i++) {
        	 sum+=day[i];
         }
         if(m2>m1) {
        	 sum +=day[m1]-d1+d2;
         }else {
        	 sum+=d2-d1;
         }
         sum++;
         System.out.println("#"+t+" "+sum);
      }
   }
}
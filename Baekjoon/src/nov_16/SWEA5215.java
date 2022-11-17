package nov_16;

/* 민기의 햄버거 선호도, dp문제
 * 난이도 : D3
 * 아이디어: dp를 이용한다.
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA5215{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] str = br.readLine().split(" ");
         int N = Integer.parseInt(str[0]);
         int L = Integer.parseInt(str[1]);
         ArrayList<int[]> arr = new ArrayList<>();
         int[] d = new int[L+1];
         Arrays.fill(d,-1)
;         d[0] = 0;
         for(int i = 0;i<N;i++) {
        	 int[] a = new int[2];
        	 str = br.readLine().split(" ");
        	 a[0] = Integer.parseInt(str[0]);
        	 a[1] = Integer.parseInt(str[1]);
        	 arr.add(a);
         }
         for(int i = 0;i<arr.size();i++) {
        	 int score = arr.get(i)[0];
        	 int cal = arr.get(i)[1];
        	 for(int j = cal;j<=L;j++) {
        		 if(d[j-cal]!= -1) {
        			 if(d[j]<d[j-cal]+score) {
        				 d[j] = d[j-cal]+score;
        			 }
        		 }
        	 }
         }
         for(int i = 0;i<L+1;i++) {
        	 System.out.println(i+": "+d[i]);
         }
      }
   }
}
package nov_2022;

/* �л����� ������ ��޺��� ���� ���
 * ���̵� : D2
 * ���̵��: ������ �Է¹޾� ���� �� ���
 * �ð����⵵: 
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1983{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      String[] scores = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
      for(int t = 0; t<T;t++) {
         String[] s = br.readLine().split(" ");
         int N = Integer.parseInt(s[0]);
         int K = Integer.parseInt(s[1]);
         int KScore = 0;
         ArrayList<Integer> score = new ArrayList<>();
         for(int i = 0;i<N;i++) {
        	 s = br.readLine().split(" ");
        	 int sum = Integer.parseInt(s[0])*35 + Integer.parseInt(s[1])*45+Integer.parseInt(s[2])*20;
        	 if(i==K-1) {
        		 KScore = sum;
        	 }
        	 score.add(sum);
         }
         Collections.sort(score);
         for(int i = 0 ;i<10;i++) {
        	 if(score.indexOf(KScore)/(N/10)==i) {
        		 System.out.println("#"+(t+1)+" "+scores[i]);
        	 }
         }
         
      }
   }
}
package algorithm2022.nov;

/* 1����N������ ���ڿ��� Ȧ���� ���ϰ� ¦���� ����
 * ���̵� : D2
 * ���̵��: N���� Ž���ؼ� %2==0 �̸� ���ϱ�
 * �ð����⵵: O(n)
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
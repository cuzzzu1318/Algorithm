package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1284{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] s = br.readLine().split(" ");
         int P = Integer.parseInt(s[0]);
         int Q = Integer.parseInt(s[1]);
         int R = Integer.parseInt(s[2]);
         int S = Integer.parseInt(s[3]);
         int W = Integer.parseInt(s[4]);
         int a = P*W;
         int b = 0;
         if(W<=R) {
        	 b = Q;
         }else {
        	 b = Q+S*(W-R);
         }
         int ans = a;
         if(a>b) {
        	 ans = b;
         }
         System.out.println("#"+t+" "+ans);
         
      }
   }
}
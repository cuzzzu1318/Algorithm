package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1984{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] str = br.readLine().split(" ");
         int[] arr = new int[10];
         for(int i = 0;i<10;i++) {
        	 arr[i] = Integer.parseInt(str[i]);
         }
         int sum = 0;
         double avg = 0;
         Arrays.sort(arr);
         for(int i = 1;i<9;i++) {
        	 sum+=arr[i];
         }
         avg = sum/8.0;
         System.out.println("#"+t+" "+Math.round(avg));
      }
   }
}
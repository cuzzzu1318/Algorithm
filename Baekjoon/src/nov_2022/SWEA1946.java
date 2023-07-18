package nov_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1946{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         int N = Integer.parseInt(br.readLine());
         ArrayList<String> arr = new ArrayList<>();
         arr.add("");
         for(int i = 0; i<N;i++) {
        	 String[] s = br.readLine().split(" ");
        	 String c = s[0];
        	 int K = Integer.parseInt(s[1]);
        	 for(int j = 0;j<K;j++) {
        		 String str = arr.get(arr.size()-1);
        		 arr.set(arr.size()-1, str+c);
        		 if(arr.get(arr.size()-1).length()==10) {
        			 arr.add("");
        		 }
        	 }
         }
         System.out.println("#"+t);
         for(String s : arr) {
        	 System.out.println(s);
         }
      }
   }
}
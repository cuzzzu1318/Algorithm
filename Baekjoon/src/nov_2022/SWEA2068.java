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
import java.util.Collections;

public class SWEA2068{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] s = br.readLine().split(" ");
         ArrayList<Integer> arr = new ArrayList<>();
         for(String str : s) {
        	 arr.add(Integer.parseInt(str));
         }
         Collections.sort(arr);
         System.out.println("#"+t+" "+arr.get(9));
      }
   }
}
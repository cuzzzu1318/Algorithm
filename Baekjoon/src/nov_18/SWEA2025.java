package nov_18;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2025{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      int sum = 0;
      for(int t = 1; t<=T;t++) {
         sum+=t;
      }
      System.out.println(sum);
   }
}

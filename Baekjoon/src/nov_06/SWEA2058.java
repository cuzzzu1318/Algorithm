package nov_06;

/*하나의 자연수를 입력받아 각 자릿수의 합 계산
 * 난이도 : D1
 * 아이디어: 문자열로 자릿수마다 나눈 후 더함
 * 시간복잡도: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2058{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] N = br.readLine().split("");
      int ans = 0;
      for(int i = 0; i<N.length;i++) {
    	  ans+=Integer.parseInt(N[i]);
      }
      System.out.println(ans);
   }
}
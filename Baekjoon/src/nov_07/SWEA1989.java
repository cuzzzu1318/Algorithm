package nov_07;

/* 회문인지 아닌지 출력, 맞으면 1 아니면 0
 * 난이도 : D2
 * 아이디어: 문자열의 중간을 기준으로 반으로 나눠 비교 후 뒷 문자열이 앞 문자열의 역순일 경우 1
 * 시간복잡도: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1989{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int i =0;i<T;i++) {
    	  String s = br.readLine().split(" ")[0];
    	  int ans = 1;
    	  int lastIndex = s.length()-1;
    	  for(int j = 0;j<s.length()/2;j++) {
    		  if(s.charAt(j)!=s.charAt(lastIndex-j)) {
    			  ans = 0;
    		  }
    	  }
    	  System.out.println("#"+(i+1)+" "+ans);
      }
   }
}
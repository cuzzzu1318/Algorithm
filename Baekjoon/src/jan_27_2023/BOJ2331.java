package jan_27_2023;

/* D[1] =A
 * D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
 * 수열을 계속 구하다 보면 반복 수열이 되는데 이 반복되는 부분을 구하는 프로그램.
 * 난이도 : 실버 4
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2331{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[]  s = br.readLine().split(" ");
      int p = Integer.parseInt(s[1]);
      ArrayList<Integer> arr = new ArrayList<>();
      int d1 = Integer.parseInt(s[0]);
      int n = d1;
      arr.add(n);
	  int n2 = n;
	  int idx = 0;
      while(true) {
    	  n2=0;
    	  for(int i = 10000;i>0;i/=10) {
    		  int num = n/i%10;
    		  n2+= Math.pow(num, p);
    	  }
    	  //System.out.println(n2);
    	  if(arr.contains(n2)) {
    		  idx = arr.indexOf(n2);
    		  break;
    	  }
    	  arr.add(n2);
    	  n=n2;
      }
      System.out.println(idx);
   }
}
package jan_05_2023;

/*
 * 난이도 : 골드 5
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2294{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split(" ");
      int N = Integer.parseInt(s[0]);
      int K = Integer.parseInt(s[1]);
      ArrayList<Integer> coins = new ArrayList<>();
      for(int i = 0;i<N;i++) {
    	  int n = Integer.parseInt(br.readLine());
    	  if(!coins.contains(n)) {
    		  coins.add(n);
    	  }
    	  
      }
      
      int[] dp = new int[K+1];
      Arrays.fill(dp, 10001);
      dp[0] = 0;
      for(int i = 0;i<coins.size();i++) {
    	  for(int j = coins.get(i);j<=K;j++) {
    		  dp[j] = Math.min(dp[j], dp[j-coins.get(i)]+1);
    	  }
      }
      if(dp[K]==10001) {
    	  System.out.println("-1");
      }else {
    	  System.out.println(dp[K]);
      }
      
   }
}
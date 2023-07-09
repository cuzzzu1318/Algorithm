package jul_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D2_SWEA1959_0709 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder sb = new StringBuilder();

   public static void main(String[] args) throws NumberFormatException, IOException {
	   int T = Integer.parseInt(br.readLine());
	   for(int t = 1;t<=T;t++) {
		   int n = Integer.parseInt(br.readLine());
		   int[] cnt = new int[101];
		   String[] s = br.readLine().split(" ");
		   for(int i = 0;i<1000;i++) {
			   int score = Integer.parseInt(s[i]);
			   cnt[score]++;
		   }
		   int max = 0;
		   int maxN = 0;
		   for(int i= 0;i<=100;i++) {
			   if(max<cnt[i]) {
				   max = cnt[i];
				   maxN = i;
			   }
		   }
		   sb.append("#"+n+" "+maxN+"\n");
	   }
	   System.out.println(sb);
      
   }
}
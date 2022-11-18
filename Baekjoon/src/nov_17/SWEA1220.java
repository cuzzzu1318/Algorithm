package nov_17;

/* 100*100판에 자성체들이 무작위로 존재할때 위 아래에 각각 N,S극의 자성이 존재하면 교착 상태는 몇개인가
 * 난이도 : D3
 * 아이디어: 아래로 향하는 성질인 자성체와 위로 향하는 자성체가 만날때를 셈.
 * 시간복잡도: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SWEA1220{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=10;t++) {
         int L = Integer.parseInt(br.readLine());
         ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
         for(int i = 0;i<100;i++) {
        	 ArrayList<Integer> a = new ArrayList<>();
        	for(String s : br.readLine().split(" ")) {
        		a.add(Integer.parseInt(s));
        	}
        	arr.add(a);
         }
         int[] temp = new int[100];
         Arrays.fill(temp, 2);
         int cnt  = 0;
         for(int i = 0;i<100;i++) {
        	 for(int j =0;j<100;j++) {
        		 if(temp[j]!=arr.get(i).get(j)&&arr.get(i).get(j)!=0) {
        			 if(temp[j]==1) {
        				 temp[j] = 2;
        				 cnt++;
        			 }else if(temp[j]==2) {
        				 temp[j] = 1;
        			 }
        		 }
        	 }
         }

         System.out.println("#"+t+" "+cnt);
         
         
         
      }
   }
}
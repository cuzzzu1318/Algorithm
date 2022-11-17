package nov_16;

/* 모든 bit가 0인 상태에서 원래 값으로 복구하는데 몇번의 수정이 필요한가?
 * 단, 비트중 하나를 수정하면 메모리의 끝까지 해당 값으로 변경된다.
 * 난이도 : D3
 * 아이디어: 0으로 시작하여 값이 변경될때마다 카운트하고 값을 갱신
 * 시간복잡도:O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1289{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         String[] s = br.readLine().split("");
         ArrayList<Integer> arr = new ArrayList<>();
         for(String str : s) {
        	 arr.add(Integer.parseInt(str));
         }
         int cur = 0;
         int cnt = 0;
         for(int i = 0;i<arr.size();i++) {
        	 if(arr.get(i)!=cur) {
        		 cur=arr.get(i);
        		 cnt++;
        	 }
         }
         System.out.println("#"+t+" "+cnt);
      }
   }
}
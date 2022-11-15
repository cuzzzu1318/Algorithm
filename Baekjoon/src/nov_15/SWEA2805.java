package nov_15;

/* N*N 크기의 농장의 농작물을 수확하여 얻을 수 있는 최대의 작물
 * 수확은 항상 농장의 크기에 맞는 정사각형 마름모 형태만 가능
 * 난이도 : D3
 * 아이디어: 농장의 가운데 줄만 따로 계산하고 윗 줄과 아랫줄을 함께 계산
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2805{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 0; t<T;t++) {
         int N = Integer.parseInt(br.readLine());
         ArrayList<ArrayList<Integer>> farm  = new ArrayList<>();
         for(int i = 0 ;i<N;i++) {
        	 ArrayList<Integer> arr = new ArrayList<>();
        	 for(String s : br.readLine().split("")) {
        		 arr.add(Integer.parseInt(s));
        	 }
        	 farm.add(arr);
         }
         int sum = 0;
         for(int i = 0;i<N/2;i++) {
        	 for(int j = 0-i;j<=i;j++) {
        		 sum+=farm.get(i).get(N/2+j)+farm.get(N-1-i).get(N/2+j);
        	 }
         }
         for(int i =0;i<N;i++) {
        	 sum+=farm.get(N/2).get(i);
         }
         System.out.println("#"+(t+1)+" "+sum);
      }
   }
}
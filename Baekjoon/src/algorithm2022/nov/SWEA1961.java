package algorithm2022.nov;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1961{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 0; t<T;t++) {
         int N = Integer.parseInt(br.readLine());
         ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
         for(int i = 0; i < N ; i++) {
        	 ArrayList<Integer> list = new ArrayList<>();
        	 for(String s : br.readLine().split(" ")) {
        		 list.add(Integer.parseInt(s));
        	 }
        	 arr.add(list);
         }
         System.out.println("#"+(t+1));
         for(int i =0;i<N;i++) {
        	 for(int j  = N-1;j>=0;j--) {
        		 System.out.print(arr.get(j).get(i));
        	 }
        	 System.out.print(" ");
        	 for(int j  = N-1;j>=0;j--) {
        		 System.out.print(arr.get(N-1-i).get(j));
        	 }
        	 System.out.print(" ");
        	 for(int j  = N-1;j>=0;j--) {
        		 System.out.print(arr.get(N-1-j).get(N-1-i));
        	 }
        	 System.out.println("");
         }
      }
   }
}
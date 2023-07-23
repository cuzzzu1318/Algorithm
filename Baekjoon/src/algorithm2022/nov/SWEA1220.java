package algorithm2022.nov;

/* 100*100�ǿ� �ڼ�ü���� �������� �����Ҷ� �� �Ʒ��� ���� N,S���� �ڼ��� �����ϸ� ���� ���´� ��ΰ�
 * ���̵� : D3
 * ���̵��: �Ʒ��� ���ϴ� ������ �ڼ�ü�� ���� ���ϴ� �ڼ�ü�� �������� ��.
 * �ð����⵵: O(n)
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
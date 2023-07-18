package nov_2022;

/* ��� bit�� 0�� ���¿��� ���� ������ �����ϴµ� ����� ������ �ʿ��Ѱ�?
 * ��, ��Ʈ�� �ϳ��� �����ϸ� �޸��� ������ �ش� ������ ����ȴ�.
 * ���̵� : D3
 * ���̵��: 0���� �����Ͽ� ���� ����ɶ����� ī��Ʈ�ϰ� ���� ����
 * �ð����⵵:O(n)
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
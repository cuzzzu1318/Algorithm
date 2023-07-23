/*10���� �� �Է¹޾� ��հ� ���
 * ���̵� : D1
 * ���̵��: ��� ���� �ݺ��ϸ� ���� �� ������ ����
 * �ð����⵵ O(n)
 * �Ҽ��� ù°�ڸ� �ݿø��� ���� �Ǽ� �ڷ����� ����Ұ�.
 * */

package algorithm2022.nov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2071 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      ArrayList<Integer> ansArr = new ArrayList<>();
      for(int i = 0;i<T;i++) {
          double sum = 0;
    	  String[] s = br.readLine().split(" ");
    	  for(int j = 0;j<10;j++) {
    		  sum+=Integer.parseInt(s[j]);
    	  }
          double avg = sum/s.length;
    	  ansArr.add((int)Math.round(avg));
      }
      int i = 1;
      for(int item : ansArr) {
    	  System.out.println("#"+(i++)+" "+item);
      }
   }
}
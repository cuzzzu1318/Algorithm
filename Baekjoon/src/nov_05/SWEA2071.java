/*10개의 수 입력받아 평균값 출력
 * 난이도 : D1
 * 아이디어: 모든 수를 반복하며 더한 후 개수로 나눔
 * 시간복잡도 O(n)
 * 소수점 첫째자리 반올림을 위해 실수 자료형을 사용할것.
 * */

package nov_05;

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
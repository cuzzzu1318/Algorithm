package algorithm2022.nov;

/* ȸ������ �ƴ��� ���, ������ 1 �ƴϸ� 0
 * ���̵� : D2
 * ���̵��: ���ڿ��� �߰��� �������� ������ ���� �� �� �� ���ڿ��� �� ���ڿ��� ������ ��� 1
 * �ð����⵵: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1989{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int i =0;i<T;i++) {
    	  String s = br.readLine().split(" ")[0];
    	  int ans = 1;
    	  int lastIndex = s.length()-1;
    	  for(int j = 0;j<s.length()/2;j++) {
    		  if(s.charAt(j)!=s.charAt(lastIndex-j)) {
    			  ans = 0;
    		  }
    	  }
    	  System.out.println("#"+(i+1)+" "+ans);
      }
   }
}
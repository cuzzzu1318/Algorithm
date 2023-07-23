package algorithm2022.nov;

/*�ϳ��� �ڿ����� �Է¹޾� �� �ڸ����� �� ���
 * ���̵� : D1
 * ���̵��: ���ڿ��� �ڸ������� ���� �� ����
 * �ð����⵵: O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2058{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] N = br.readLine().split("");
      int ans = 0;
      for(int i = 0; i<N.length;i++) {
    	  ans+=Integer.parseInt(N[i]);
      }
      System.out.println(ans);
   }
}
package algorithm2022.nov;

/* ���� N�� ����� ������ �� ���
 * ���̵� : D1
 * ���̵��: ���� ������ ���̺��ϰ� ���
 * �ð����⵵:O(n)
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1933{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 1; t<=T;t++) {
         if(T%t==0) {
        	 System.out.print(t+" ");
         }
      }
   }
}
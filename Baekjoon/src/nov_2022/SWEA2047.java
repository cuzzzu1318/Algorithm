package nov_2022;

/* ���ĺ� �ҹ��ڸ� ��� �빮�ڷ� ��ȯ
 * ���̵� : D1
 * ���̵��: toUpperCase ���
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2047{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      s = s.toUpperCase();
      System.out.println(s);
      
   }
}
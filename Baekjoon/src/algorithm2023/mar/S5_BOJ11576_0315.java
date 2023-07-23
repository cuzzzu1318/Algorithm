package algorithm2023.mar;

/*  A������ B�������� �ٲٱ�
 * ���̵� : �ǹ�5
 * ���̵��: �ܼ� divide�� mod�ε� �Ӹ��� �ȱ�����
 * �ФФ�
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ11576_0315 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String[] s = br.readLine().split(" ");
      int A = Integer.parseInt(s[0]);
      int B = Integer.parseInt(s[1]);
      //�̷����迡�� ����ϴ� A������ ���̰� ����ϴ� B����
      
      int m = Integer.parseInt(br.readLine());
      int dec = 0;
      s = br.readLine().split(" ");
      for(int i = 1;i<=m;i++) {
    	  int n = (int) (Integer.parseInt(s[i-1])*Math.pow(A, m-i));
    	  dec+=n;
      }
      ArrayList<Integer> ans = new ArrayList<>();
      while(dec>0) {
    	  ans.add(dec%B);
    	  dec/=B;
      }
      for(int i = ans.size()-1;i>=0;i--) {
    	  bw.write(ans.get(i)+" ");
      }
      bw.flush();
      bw.close();
   }
}
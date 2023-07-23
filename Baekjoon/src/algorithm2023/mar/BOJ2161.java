package algorithm2023.mar;
/*  ������ 1, �� �Ʒ��� N�� ī�����
 * ī�� ������ > �� �� ī�� �� �Ʒ��� �ֱ�
 * �������� ī�� ���. ī�尡 1�� ������ ���� ī�� ���
 * ***N�� 1�� ��� ���� ���ؼ� ���� �ɸ�***
 * ���̵� : �ǹ�5
 * ���̵��: ť�� ����
 * �ð����⵵:
 * �ҿ� �ð�: 18:10~18:25(15min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int N = Integer.parseInt(br.readLine());
      
      Queue<Integer> q = new LinkedList<>();
      for(int i = 1;i<=N;i++) {
    	  q.add(i);
      }
      while(q.size()>1) {
    	bw.write(Integer.toString(q.poll())+" ");
    	q.add(q.poll());
      }    		
      bw.write(Integer.toString(q.poll()));

      bw.flush();
      bw.close();
      
   }
}
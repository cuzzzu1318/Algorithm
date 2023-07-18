package nov_2022;


/* ���� ���� �� ���� ���� ���̸� ���� ���� ���̷� �ϳ��� �̵��ϸ� ���������� max�� min�� ���� ����
 * ���̵� : D3
 * ���̵��: ���� ����Ʈ�� �����Ͽ� ������ �ε����� ó�� �ε����� ���� 1�� ������ �ִ� ���� �ݺ� �� N�� ������ ���� ��ȯ
 * �ð����⵵: ���ĸ޼ҵ��� ���⵵(O(nlong))*N
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1208{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      ArrayList<Integer> ansList = new ArrayList<>();
      for(int i =0;i<10;i++) {
    	  int N = Integer.parseInt(br.readLine());
    	  ArrayList<Integer> boxes = new ArrayList<>();
    	  for(String s : br.readLine().split(" ")) {
    		  boxes.add(Integer.parseInt(s));
    	  }
    	  for(int j = 0;j<N;j++) {
    		  Collections.sort(boxes);
    		  boxes.set(0, boxes.get(0)+1);
    		  boxes.set(boxes.size()-1, boxes.get(boxes.size()-1)-1);
    	  }
		  Collections.sort(boxes);
    	  ansList.add(boxes.get(boxes.size()-1)-boxes.get(0));
    	  System.out.println("#"+(i+1)+" "+ansList.get(i));
      }
   }
}
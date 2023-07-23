package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class S2_BOJ1874_0425 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      int n= Integer.parseInt(br.readLine());
      //�־��� ���� ����
      int num = 1;
      //���ÿ� �� ��
      Stack<Integer> st = new Stack<>();
      ArrayList<String> ans = new ArrayList<>();
      //���� ���� �迭
      
      for(int i = 0;i<n;i++) {
    	  int input = Integer.parseInt(br.readLine());
    	  //�Էµ� ��
    	  if(input>=num) {
    		  //���� ���ÿ� input�� ���� ���� �Էµ��� �ʾҴٸ�
    		  for(int j = num;j<=input;j++) {
    			  //num���� input���� push
    			  st.push(num++);
    			  ans.add("+");
    		  }
    		  //pop�����ν� input�� ��
    		  st.pop();
    		  ans.add("-");
    	  }else {
    		  //�̹� input�� ���ÿ� �־��ٸ�
    		  if(st.isEmpty()) {
    			  //������ ��������� ���� �� �� �����Ƿ� NO���
    			  ans.clear();
    			  ans.add("NO");
    			  break;
    		  }
    		  //���ÿ� ���� �ִ� ���
    		  int top = st.peek();
    		  //�� ��� �� top
    		  if(top>=input) {
    			  //top�� input���� ũ�ٸ� ���� ���� input�� �ִٴ� ��.
    			  for(int j = top;j>=input;j=st.peek()) {
    				  //������ ���������� Ž��
    				  st.pop();
    				  ans.add("-");
    				  if(st.isEmpty()) {
    					  //������ ����ٸ� ���� ���⼭ �������� �ʴ´ٸ� peek���� ���� ��µ�
    					  break;
    				  }
    			  }
    		  }else {
    			  //top�� input���� �۴ٸ� �̹� input ���� pop�Ǿ��ٴ� ���̹Ƿ� NO���
    			  ans.clear();
    			  ans.add("NO");
    			  break;
    		  }
    	  }
      }
      
      for(String s : ans) {
    	  bw.write(s+"\n");
      }
      bw.flush();
      bw.close();
      
   }
}
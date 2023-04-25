package april_2023;

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
      //주어질 수의 개수
      int num = 1;
      //스택에 들어갈 수
      Stack<Integer> st = new Stack<>();
      ArrayList<String> ans = new ArrayList<>();
      //답을 담을 배열
      
      for(int i = 0;i<n;i++) {
    	  int input = Integer.parseInt(br.readLine());
    	  //입력된 수
    	  if(input>=num) {
    		  //현재 스택에 input과 같은 값이 입력되지 않았다면
    		  for(int j = num;j<=input;j++) {
    			  //num부터 input까지 push
    			  st.push(num++);
    			  ans.add("+");
    		  }
    		  //pop함으로써 input을 얻어냄
    		  st.pop();
    		  ans.add("-");
    	  }else {
    		  //이미 input을 스택에 넣었다면
    		  if(st.isEmpty()) {
    			  //스택이 비어있으면 값을 얻어낼 수 없으므로 NO출력
    			  ans.clear();
    			  ans.add("NO");
    			  break;
    		  }
    		  //스택에 값이 있는 경우
    		  int top = st.peek();
    		  //최 상단 값 top
    		  if(top>=input) {
    			  //top이 input보다 크다면 스택 내에 input이 있다는 뜻.
    			  for(int j = top;j>=input;j=st.peek()) {
    				  //스택의 위에서부터 탐색
    				  st.pop();
    				  ans.add("-");
    				  if(st.isEmpty()) {
    					  //스택이 비었다면 종료 여기서 종료하지 않는다면 peek에서 에러 출력됨
    					  break;
    				  }
    			  }
    		  }else {
    			  //top이 input보다 작다면 이미 input 값은 pop되었다는 것이므로 NO출력
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
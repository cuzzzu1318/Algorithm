package jan_27_2023;

/* 주어지는 문자열로 팰린드롬을 만들 수 있는가?
 * 만들 수 있다면 사전순으로 앞서는 팰린드롭 출력, 없다면 I'm Sorry Hansoo 출력
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1213{
	
	static boolean isPal(String[] s) {
		for(int i = 0;i<s.length;i++) {
			if(s[i]!=s[s.length-1-i]) {
				return false;
			}else if(s[i]==null) {
				return false;
			}
		}
		return true;
	}
	
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] s = br.readLine().split("");
      String[] arr = new String[s.length];
      Arrays.sort(s);
      int start = 0;
      int end = s.length-1;
      int mid = s.length/2;
      for(int i = 0;i<s.length;i++) {
    	  if(i<s.length-1&&s[i].equals(s[i+1])) {
    		  arr[start] = s[i];
    		  arr[end] =  s[i];
    		  start++;
    		  end--;
    		 // System.out.println(s[i]+" "+start+" "+end);
    		  i++;
    	  }else {
    		  arr[mid] = s[i];
    	  }
      }
      
      if(isPal(arr)) {
    	  for(String c : arr) {
    		  System.out.print(c);
    	  }
      }else {
    	  System.out.println("I'm Sorry Hansoo");
      }
      
   }
}
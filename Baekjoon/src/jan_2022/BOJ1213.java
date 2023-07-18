package jan_2022;

/* �־����� ���ڿ��� �Ӹ������ ���� �� �ִ°�?
 * ���� �� �ִٸ� ���������� �ռ��� �Ӹ���� ���, ���ٸ� I'm Sorry Hansoo ���
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
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
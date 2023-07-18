package dec_2022;

/* ����ġ �Ѱ� ����
 * ���̵� : �ǹ� 4
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1244{
	
	public static void change(ArrayList<Integer> sw, int index) {
		if(sw.get(index)==1) {
			sw.set(index, 0);
		}else {
			sw.set(index, 1);
		}
	}
	
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      ArrayList<Integer> sw = new ArrayList<>();
      sw.add(2);
      String[] s = br.readLine().split(" ");
      for(int i = 0;i<N;i++) {
    	  sw.add(Integer.parseInt(s[i]));
      }
      int M = Integer.parseInt(br.readLine());
      for(int i = 0;i<M;i++) {
    	  s = br.readLine().split(" ");
    	  int g = Integer.parseInt(s[0]);
    	  int num = Integer.parseInt(s[1]);
    	  if(g == 1) {
    		  for(int j = 1;j<=N;j++) {
    			  if(j%num==0) {
    				  change(sw, j);
    			  }
    		  }
    	  }else {
    		  change(sw, num);
    		  int r;
    		  int l;
    		  for(int j = 1;j<=N/2;j++) {
    			  r = num+j;
    			  l = num-j;
    			  if(r>N||l<1) {
    				  break;
    			  }
    			  if(sw.get(r)==sw.get(l)) {
    				  change(sw,r);
    				  change(sw,l);
    			  }else {
    				  break;
    			  }
    		  }
    	  }
      }
      sw.remove(0);
      int cnt = 0;
      for(int i = 0;i<sw.size();i++) {
    	  System.out.print(sw.get(i)+" ");
    	  cnt++;
    	  if(cnt%20==0) {
    		  System.out.println("");
    	  }
      }
   }
}
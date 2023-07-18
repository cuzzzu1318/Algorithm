package nov_2022;

/* 1���� N������ ���� �̾�� ���ڸ����� ����
 * ���̵� : �ǹ� 4
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1748{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      long N = Long.parseLong(br.readLine());
      long cnt = 0;;
      for(long i = 1;i<=N;i++) {
    	  cnt++;
    	  if(i>9&&i<100) {
    		  cnt++;
    	  }if(i>99&&i<1000) {
    		  cnt+=2;
    	  }if(i>999&&i<10000) {
    		  cnt+=3;
    	  }if(i>9999&&i<100000) {
    		  cnt+=4;
    	  }if(i>99999&&i<1000000) {
    		  cnt+=5;
    	  }if(i>999999&&i<10000000) {
    		  cnt+=6;
    	  }if(i>9999999&&i<100000000) {
    		  cnt+=7;
    	  }if(i==100000000) {
    		  cnt+=8;
    	  }
    	  
    	  
      }
      System.out.println(cnt);
      
   }
}
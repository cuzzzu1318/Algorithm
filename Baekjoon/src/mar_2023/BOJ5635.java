package mar_2023;

/*  
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class BOJ5635 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      Date minDate = new Date(2010,12,31);
      String minName = "";
      Date maxDate = new Date(1990,1,1);
      String maxName = "";
      for(int i = 0;i<n;i++) {
    	  String[] s = br.readLine().split(" ");
    	  String name = s[0];
    	  int dd = Integer.parseInt(s[1]);
    	  int mm = Integer.parseInt(s[2]);
    	  int yy = Integer.parseInt(s[3]);
    	  Date date = new Date(yy,mm,dd);
    	  if(date.compareTo(minDate)<0) {
    		  minDate = date;
    		  minName = name;
    	  }
    	  if(date.compareTo(maxDate)>0) {
    		  maxDate = date;
    		  maxName = name;
    	  }
      }
      bw.write(maxName+"\n"+minName+"\n");
      bw.flush();
      bw.close();
   }
}
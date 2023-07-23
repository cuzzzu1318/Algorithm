package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S5_BOJ1251_0316 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String s = br.readLine();
      ArrayList<String> arr = new ArrayList<>();
      
      for(int i = 1;i<s.length()-2;i++) {
    	  for(int j = i+1;j<s.length();j++) {
    		  String s1 = s.substring(0,i);
    		  String s1R = "";
    		  for(int k = s1.length()-1;k>=0;k--) {
    			  s1R+=s1.charAt(k);
    		  }
    		  String s2 = s.substring(i,j);
    		  String s2R = "";
    		  for(int k = s2.length()-1;k>=0;k--) {
    			  s1R+=s2.charAt(k);
    		  }
    		  String s3 = s.substring(j,s.length());
    		  String s3R = "";
    		  for(int k = s3.length()-1;k>=0;k--) {
    			  s1R+=s3.charAt(k);
    		  }
    		  //bw.write(s1+"\n"+s2+"\n"+s3+"\n");
    		  //bw.write(s1R+"\n"+s2R+"\n"+s3R+"\n");
    		  String reverse = s1R+s2R+s3R;
    		  arr.add(reverse);
    	  }
      }
      Collections.sort(arr);
      //System.out.println(arr);
      bw.write(arr.get(0));
      bw.flush();
      bw.close();
      
   }
}
package algorithm2022.nov;
/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SWEA1928{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      ArrayList<String> ansList = new ArrayList<>();
      for(int i = 0;i<T;i++) {
    	  byte[] s = br.readLine().getBytes();
    	  Decoder decoder = Base64.getDecoder();
    	  byte[] decoded = decoder.decode(s);
    	  ansList.add(new String(decoded));
      }
      int i =1;
      for(String s : ansList) {
    	  System.out.println("#"+i+++" "+s);
      }
   }
}
package mar_2023;

/*  나이트투어. 올바르면 valid, 아니면 invalid.
 * 난이도 : 실버 5
 * 아이디어: 
 * 시간복잡도:
 * 소요 시간: 21:40~ 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ1331_0322 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   public static void main(String[] args) throws NumberFormatException, IOException {
	   char[] s = br.readLine().toCharArray();
	   int x = s[0]-'A';
	   int y = s[1]-'1';
	   int startX = x;
	   int startY = y;
	   boolean[][] v = new boolean[6][6];
	   v[x][y]=true;
	   boolean isValid = true;
	   for(int i = 0;i<35;i++) {
		   s = br.readLine().toCharArray();
		   int x1 = s[0]-'A';
		   int y1 = s[1]-'1';
		   //System.out.println(x-x1);
		   //System.out.println(y-y1);
		   if(v[x1][y1]) {
			   isValid = false;
			   break;
		   }
		   v[x1][y1]=true;
		   
		   if(Math.abs(x-x1)==2&&Math.abs(y-y1)==1) {
			   isValid=true;
			   x=x1;
			   y=y1;
		   }else if(Math.abs(x-x1)==1&&Math.abs(y-y1)==2) {
			   isValid = true;
			   x=x1;
			   y=y1;
		   }else {
			   isValid=false;
			   break;
		   }
		   if(i==34) {
			   if(Math.abs(x-startX)==2&&Math.abs(y-startY)==1) {
				   isValid=true;
				   x=x1;
				   y=y1;
			   }else if(Math.abs(x-startX)==1&&Math.abs(y-startY)==2) {
				   isValid = true;
				   x=x1;
				   y=y1;
			   }else {
				   isValid=false;
				   break;
			   }
		   }
	   }
	   if(isValid) {
		   bw.write("Valid");
	   }else {
		   bw.write("Invalid");
	   }
	   bw.flush();
   }
}
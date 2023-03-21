package mar_2023;

/*  변수명 형식 바꿔주기
 * 	Java는 단어가바뀔때마다 대문자, C는 단어가 바뀔때 언더바
 * 	둘다 아니면 Error! 출력
 * 난이도 : 실버 3
 * 아이디어: 단순히 바꿔줬는데 생각보다 Error가 많음.
 * 시간복잡도:
 * 소요 시간:	15분 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S3_BOJ3613_0321 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   static String cOrJava(char[] var) {
	   String ret = "";
	   boolean isC = false;
	   boolean isJava = false;
	   
	   for(int i =0 ;i<var.length;i++) {
		   if(Character.isUpperCase(var[i])) {
			   if(i==0) {
				   ret="Error!";
				   break;
			   }
			   isJava=true;
			   ret+="_"+Character.toLowerCase(var[i]);
		   }else if(var[i]=='_') {
			   if(i==var.length-1||i==0) {
				   ret = "Error!";
				   break;
			   }
			   isC=true;
			   if(Character.isUpperCase(var[i+1])||var[i+1]=='_') {
				   ret ="Error!";
				   break;
			   }
			   ret+=Character.toUpperCase(var[i+1]);
			   i++;
		   }else {
			   ret+=var[i];
		   }
		   if(isJava&&isC) {
			   ret = "Error!";
		   }
	   }
	   
	   return ret;
   }
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	   char[] var = br.readLine().toCharArray();
	   bw.write(cOrJava(var));
	   bw.flush();
	   bw.close();
   }
}
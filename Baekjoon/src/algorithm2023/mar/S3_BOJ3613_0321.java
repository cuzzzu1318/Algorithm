package algorithm2023.mar;

/*  ������ ���� �ٲ��ֱ�
 * 	Java�� �ܾ�ٲ𶧸��� �빮��, C�� �ܾ �ٲ� �����
 * 	�Ѵ� �ƴϸ� Error! ���
 * ���̵� : �ǹ� 3
 * ���̵��: �ܼ��� �ٲ���µ� �������� Error�� ����.
 * �ð����⵵:
 * �ҿ� �ð�:	15�� 
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
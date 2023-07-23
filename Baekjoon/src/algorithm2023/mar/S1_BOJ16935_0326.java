package algorithm2023.mar;

/*  
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * �ҿ� �ð�: 15:20~
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S1_BOJ16935_0326 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   static int N;
   static int M;
   static int R;
   

   static void calc1(int[][] arr){
	   for(int i = 0;i<arr.length/2;i++) {
		   for(int j = 0;j<arr[0].length;j++) {
			   int temp = arr[i][j];
			   arr[i][j] = arr[arr.length-1-i][j];
			   arr[arr.length-1-i][j]=temp;
		   }
	   }
   }
   
   static void calc2(int[][] arr){
	   for(int i = 0;i<arr[0].length/2;i++) {
		   for(int j = 0;j<arr.length;j++) {
			   int temp = arr[j][i];
			   arr[j][i] = arr[j][arr[0].length-1-i];
			   arr[j][arr[0].length-1-i]=temp;
		   }
	   }
   }
   
   static int[][] calc3(int[][] arr){
	   int[][] ret = new int[arr[0].length][arr.length];
	   
	   for(int i = 0;i<arr.length;i++) {
		   for(int j = 0;j<arr[0].length;j++) {
			   ret[j][arr.length-1-i] = arr[i][j];
			   
		   }
	   }
	   
	   return ret;
   }
   
   static int[][] calc4(int[][] arr){
	   int[][] ret = new int[arr[0].length][arr.length];
	   
	   for(int i = 0;i<arr.length;i++) {
		   for(int j = 0;j<arr[0].length;j++) {
			   ret[arr[0].length-1-j][i] = arr[i][j];
			   
		   }
	   }
	   
	   return ret;
   }
   
   static void calc5(int[][] arr){
	   int N2 = arr.length/2;
	   int M2 = arr[0].length/2;
	   
	   
	   
	   for(int i = 0;i<arr.length/2;i++) {
		   for(int j = 0;j<arr[0].length/2;j++) {
			   int temp = arr[i][j];
			   arr[i][j] = arr[N2+i][j];
			   arr[N2+i][j] = arr[N2+i][M2+j];
			   arr[N2+i][M2+j] = arr[i][M2+j];
			   arr[i][M2+j] = temp;
		   }
	   }
	   
   }
   
   static void calc6(int[][] arr){
	   int N2 = arr.length/2;
	   int M2 = arr[0].length/2;
	   
	   
	   
	   for(int i = 0;i<arr.length/2;i++) {
		   for(int j = 0;j<arr[0].length/2;j++) {
			   int temp = arr[i][j];
			   arr[i][j] = arr[i][M2+j];
			   arr[i][M2+j] = arr[N2+i][M2+j];
			   arr[N2+i][M2+j] = arr[N2+i][j];
			   arr[N2+i][j] = temp;
		   }
	   }
	   
   }
   
   
   static void print(int[][] arr) throws IOException {
	   for(int i = 0;i<arr.length;i++) {
		   for(int j = 0;j<arr[0].length;j++) {
			   bw.write(arr[i][j]+" ");
		   }
		   bw.write("\n");
	   }
	   bw.write("\n");
   }
   
   
   public static void main(String[] args) throws NumberFormatException, IOException {
	   String[] s = br.readLine().split(" ");
	   N = Integer.parseInt(s[0]);
	   M = Integer.parseInt(s[1]);
	   R = Integer.parseInt(s[2]);
	   int[][] arr = new int[N][M];
	   
	   for(int i = 0;i<N;i++) {
		   s = br.readLine().split(" ");
		   for(int j =0;j<M;j++) {
			   arr[i][j] = Integer.parseInt(s[j]);
		   }
	   }
	   s = br.readLine().split(" ");
	   for(int i = 0;i<R;i++) {
		   int n = Integer.parseInt(s[i]);
		   switch(n) {
		   case 1:
			   calc1(arr);
			   break;
		   case 2: 
			   calc2(arr);
			   break;
		   case 3:
			   arr=calc3(arr);
			   break;
		   case 4:
			   arr = calc4(arr);
			   break;
		   case 5:
			   calc5(arr);
			   break;
		   case 6:
			   calc6(arr);
			   break;
			   default:
				   break;
		   }
		   
		   
			   
	   }
	   
	   
	   print(arr);
	   bw.flush();
	   bw.close();
	   
	   
	   
   }
}
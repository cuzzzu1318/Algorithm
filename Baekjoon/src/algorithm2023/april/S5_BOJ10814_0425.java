package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S5_BOJ10814_0425 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      int N = Integer.parseInt(br.readLine());
      String[][] arr = new String[N][2];
      for(int i = 0;i<N;i++) {
    	  arr[i] = br.readLine().split(" ");
      }
      Arrays.sort(arr, (e1, e2) ->{
    	  return Integer.parseInt(e1[0])-Integer.parseInt(e2[0]);
      });
      for(int i = 0;i<N;i++) {
    	  bw.write(arr[i][0]+" "+arr[i][1]+"\n");
      }
      bw.flush();
      bw.close();
   }
   
}
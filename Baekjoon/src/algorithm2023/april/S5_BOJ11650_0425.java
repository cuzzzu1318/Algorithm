package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class S5_BOJ11650_0425 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      int N = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
      for(int i = 0;i<200001;i++) {
    	  ArrayList<Integer> a = new ArrayList<>();
    	  arr.add(a);
      }
      for(int i = 0;i<N;i++) {
    	  String[] s = br.readLine().split(" ");
    	  int x = Integer.parseInt(s[0])+100000;
    	  int y = Integer.parseInt(s[1])+100000;
    	  arr.get(x).add(y);
      }
      for(int i = 0;i<200001;i++) {
    	  Collections.sort(arr.get(i));
    	  for(int n : arr.get(i)) {
    		  int x = i-100000;
    		  int y = n-100000;
    		  bw.write(Integer.toString(x)+" "+Integer.toString(y)+"\n");
    	  }
      }
      bw.flush();
      bw.close();
   }
   
   
}
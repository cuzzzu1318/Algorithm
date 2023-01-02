package jan_02_2023;

/*
 * 난이도 : 
 * 아이디어: 
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10973{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      String[] s = br.readLine().split(" ");
      ArrayList<Integer> arr = new ArrayList<>();
      for(int i = 0;i<N;i++) {
    	  arr.add(Integer.parseInt(s[i]));
      }
      boolean isFirst = true;
      int K = 0;
      for(int i = 0;i<N-1;i++) {
    	  if(arr.get(i)>arr.get(i+1)) {
    		  K = i;
    		  isFirst=false;
    	  }
      }
      //System.out.println("K: "+K);
      int index = K;
      int K1 = 0;
      for(int i = K+1;i<N;i++) {
    	  if(arr.get(i)<arr.get(K)) {
    		  if(arr.get(i)>K1) {
    			  index=i;
    			  K1=arr.get(i);
    		  }
    	  }
      }
   //   System.out.println("K1: "+K1+" index: "+index);
      
      int temp = arr.get(K);
      arr.set(K, arr.get(index));
      arr.set(index, temp);
     // System.out.println(arr.get(K+1));
      ArrayList<Integer> arr1 = new ArrayList<>();
      while(arr.size()>K+1) {
    	  arr1.add(arr.get(K+1));
    	  arr.remove(K+1);
    	//  System.out.println(arr);
      }
      Collections.sort(arr1,Collections.reverseOrder());
      arr.addAll(arr1);
     
      
      if(isFirst) {
    	  System.out.println("-1");
      }else {
    	  for(int n : arr) {
    		  System.out.print(n+" ");
    	  }
      }
   }
}
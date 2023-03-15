package mar_2023;

/*  A진법을 B진법으로 바꾸기
 * 난이도 : 실버5
 * 아이디어: 단순 divide랑 mod인데 머리가 안굴러가
 * ㅠㅠㅠ
 * 시간복잡도:
 * 소요 시간: 
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class S5_BOJ11576_0315 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      String[] s = br.readLine().split(" ");
      int A = Integer.parseInt(s[0]);
      int B = Integer.parseInt(s[1]);
      //미래세계에서 사용하는 A진법과 정이가 사용하는 B진법
      
      int m = Integer.parseInt(br.readLine());
      int dec = 0;
      s = br.readLine().split(" ");
      for(int i = 1;i<=m;i++) {
    	  int n = (int) (Integer.parseInt(s[i-1])*Math.pow(A, m-i));
    	  dec+=n;
      }
      ArrayList<Integer> ans = new ArrayList<>();
      while(dec>0) {
    	  ans.add(dec%B);
    	  dec/=B;
      }
      for(int i = ans.size()-1;i>=0;i--) {
    	  bw.write(ans.get(i)+" ");
      }
      bw.flush();
      bw.close();
   }
}
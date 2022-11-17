package nov_16;

/* 알파벳 소문자를 모두 대문자로 변환
 * 난이도 : D1
 * 아이디어: toUpperCase 사용
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2047{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      s = s.toUpperCase();
      System.out.println(s);
      
   }
}
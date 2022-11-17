package nov_16;

/* 입력만큼 #찍기
 * 난이도 : D1
 * 아이디어: for문 조건에 입력값 넣기
 * 시간복잡도:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2046{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 0; t<T;t++) {
         System.out.print("#");
      }
   }
}
package mar_2023;
/*  맨위가 1, 맨 아래가 N인 카드더미
 * 카드 버리기 > 맨 위 카드 맨 아래에 넣기
 * 버려지는 카드 출력. 카드가 1장 남으면 남은 카드 출력
 * ***N이 1인 경우 생각 못해서 오래 걸림***
 * 난이도 : 실버5
 * 아이디어: 큐로 구현
 * 시간복잡도:
 * 소요 시간: 18:10~18:25(15min)
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int N = Integer.parseInt(br.readLine());
      
      Queue<Integer> q = new LinkedList<>();
      for(int i = 1;i<=N;i++) {
    	  q.add(i);
      }
      while(q.size()>1) {
    	bw.write(Integer.toString(q.poll())+" ");
    	q.add(q.poll());
      }    		
      bw.write(Integer.toString(q.poll()));

      bw.flush();
      bw.close();
      
   }
}
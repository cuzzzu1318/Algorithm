package nov_05;


/* 상자 더미 중 가장 높은 더미를 가장 낮은 더미로 하나씩 이동하며 최종적으로 max와 min의 차를 구함
 * 난이도 : D3
 * 아이디어: 상자 리스트를 정렬하여 마지막 인덱스와 처음 인덱스의 값을 1씩 조정해 주는 것을 반복 후 N번 이후의 값을 반환
 * 시간복잡도: 정렬메소드의 복잡도(O(nlong))*N
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1208{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      ArrayList<Integer> ansList = new ArrayList<>();
      for(int i =0;i<10;i++) {
    	  int N = Integer.parseInt(br.readLine());
    	  ArrayList<Integer> boxes = new ArrayList<>();
    	  for(String s : br.readLine().split(" ")) {
    		  boxes.add(Integer.parseInt(s));
    	  }
    	  for(int j = 0;j<N;j++) {
    		  Collections.sort(boxes);
    		  boxes.set(0, boxes.get(0)+1);
    		  boxes.set(boxes.size()-1, boxes.get(boxes.size()-1)-1);
    	  }
		  Collections.sort(boxes);
    	  ansList.add(boxes.get(boxes.size()-1)-boxes.get(0));
    	  System.out.println("#"+(i+1)+" "+ansList.get(i));
      }
   }
}
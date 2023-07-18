package nov_2022;

/* N*N ũ���� ������ ���۹��� ��Ȯ�Ͽ� ���� �� �ִ� �ִ��� �۹�
 * ��Ȯ�� �׻� ������ ũ�⿡ �´� ���簢�� ������ ���¸� ����
 * ���̵� : D3
 * ���̵��: ������ ��� �ٸ� ���� ����ϰ� �� �ٰ� �Ʒ����� �Բ� ���
 * �ð����⵵:
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA2805{
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      for(int t = 0; t<T;t++) {
         int N = Integer.parseInt(br.readLine());
         ArrayList<ArrayList<Integer>> farm  = new ArrayList<>();
         for(int i = 0 ;i<N;i++) {
        	 ArrayList<Integer> arr = new ArrayList<>();
        	 for(String s : br.readLine().split("")) {
        		 arr.add(Integer.parseInt(s));
        	 }
        	 farm.add(arr);
         }
         int sum = 0;
         for(int i = 0;i<N/2;i++) {
        	 for(int j = 0-i;j<=i;j++) {
        		 sum+=farm.get(i).get(N/2+j)+farm.get(N-1-i).get(N/2+j);
        	 }
         }
         for(int i =0;i<N;i++) {
        	 sum+=farm.get(N/2).get(i);
         }
         System.out.println("#"+(t+1)+" "+sum);
      }
   }
}
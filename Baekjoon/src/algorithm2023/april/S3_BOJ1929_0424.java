package algorithm2023.april;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S3_BOJ1929_0424 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

   public static void main(String[] args) throws NumberFormatException, IOException {
	   StringTokenizer st = new StringTokenizer(br.readLine()," ");
	   int M = Integer.parseInt(st.nextToken());
	   int N = Integer.parseInt(st.nextToken());
	   int[] arr = new int[1000001];
	   //�����佺�׳׽��� ü�� ������ �迭 ����
	   arr[1]=1;
	   //2���� �ݺ��� ���̰� 1�� �Ҽ��� �ƴϹǷ� 1�� ��ŷ
	   for(int i =2;i<=1000000;i++) {
		   //2���� ������ �ݺ��Ͽ�
		   if(arr[i]==1) {
			   //�Ҽ��� �ƴ϶�� ��ŷ�Ǿ� �ִٸ� continue
			   continue;
		   }else {
			   //��ŷ�Ǿ� ���� �ʴٸ� �ش� ���� ��� ��� ��ŷ
			   for(int j = i+i;j<=1000000;j+=i) {
				   arr[j] = 1;
			   }
		   }
	   }
	   
	   for(int i = M;i<=N;i++) {
		   if(arr[i]!=1) {
			   //��ŷ���� ���� �� ���
			   bw.write(Integer.toString(i)+"\n");
		   }
	   }
	   
	   bw.flush();
	   bw.close();
   }
}
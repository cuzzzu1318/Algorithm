package april_2023;

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
	   //에라토스테네스의 체를 적용할 배열 선언
	   arr[1]=1;
	   //2부터 반복할 것이고 1은 소수가 아니므로 1은 마킹
	   for(int i =2;i<=1000000;i++) {
		   //2부터 끝까지 반복하여
		   if(arr[i]==1) {
			   //소수가 아니라고 마킹되어 있다면 continue
			   continue;
		   }else {
			   //마킹되어 있지 않다면 해당 수의 배수 모두 마킹
			   for(int j = i+i;j<=1000000;j+=i) {
				   arr[j] = 1;
			   }
		   }
	   }
	   
	   for(int i = M;i<=N;i++) {
		   if(arr[i]!=1) {
			   //마킹되지 않은 수 출력
			   bw.write(Integer.toString(i)+"\n");
		   }
	   }
	   
	   bw.flush();
	   bw.close();
   }
}
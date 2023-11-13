import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N,a,b;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		boolean flag = true;
		int[] arr = new int[N+1];
		if(a+b<=N+1) {
			flag = false;
			
		}
		
		
		
		
		if(flag) {
			System.out.println(-1);
		}else {
			for(int i =1;i<=N;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
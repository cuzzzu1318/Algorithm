package april_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class S3_OBOJ9095_0429 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] nums = {1,2,3};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			bw.write(Integer.toString(count(n))+"\n");
		}
			bw.flush();
			bw.close();
	}
	
	static int count(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0) {
			return 1;
		}else {
			int cnt = 0;
			for(int i = 0;i<3;i++) {
				cnt +=count(n-nums[i]);
			}
			return cnt;
		}
		
	}
	
	
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		Arrays.fill(arr, 5);
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 1;i<=Math.sqrt(n);i++) {
			for(int j = i*i;j<=n;j++) {
				arr[j] = Math.min(arr[j-i*i]+1, arr[j]);
			}
		}
		System.out.println(arr[n]);
	}
	
	
}
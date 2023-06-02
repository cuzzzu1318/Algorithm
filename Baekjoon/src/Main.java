
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		for(int i= 0;i<N;i++) {
			makeArr(nums, i, 1, "");
		}
		
		System.out.println(sb);

	}

	static void makeArr(int[] num,int n, int m, String str) {
		str += Integer.toString(num[n]) + " ";
		if (m == M) {
			sb.append(str + "\n");
			return;
		}
		for (int i = n; i < N; i++) {
			makeArr(num, i, m + 1, str);
			
		}
	}
}
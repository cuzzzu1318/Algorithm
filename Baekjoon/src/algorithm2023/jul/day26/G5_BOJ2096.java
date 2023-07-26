package algorithm2023.jul.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G5_BOJ2096 {
	static int N, max[], min[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = new int[3];
		min = new int[3];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			dp(i,s);
		}
		int ans1 = 0;
		int ans2 = Integer.MAX_VALUE;
		for(int i= 0;i<3;i++) {
			ans1 = Math.max(ans1, max[i]);
			ans2 = Math.min(ans2, min[i]);
		}
		System.out.println(ans1+" "+ans2);
	}

	static void dp(int i, String[] s) {
		int[] maxRet = new int[3];
		int[] minRet = new int[3];
		for (int j = 0; j < 3; j++) {
			int n = Integer.parseInt(s[j]);
			if (i == 0) {
				maxRet[j] = n;
				minRet[j] = n;
			} else {
				int maxSum = 0;
				int minSum = Integer.MAX_VALUE;
				for (int k = -1; k < 2; k++) {
					if (isValid(i - 1, j + k)) {
						maxSum = Math.max(maxSum, max[j + k] + n);
						minSum = Math.min(minSum, min[j + k] + n);
					}
				}
				maxRet[j] = maxSum;
				minRet[j] = minSum;
			}
		}
		
		max = maxRet;
		min =minRet;

	}

	static boolean isValid(int i, int j) {
		if (i < 0 || j < 0 || i >= 3 || j >= 3) 
			return false;
		return true;
	}
}
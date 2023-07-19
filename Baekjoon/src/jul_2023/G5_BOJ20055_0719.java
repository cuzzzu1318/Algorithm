package jul_2023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G5_BOJ20055_0719 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[] conv = new int[2*N];
		ArrayList<Integer> robot = new ArrayList<>();
		int up = 0;
		int down = N-1;
		s = br.readLine().split(" ");
		for(int i= 0;i<2*N;i++) {
			conv[i] = Integer.parseInt(s[i]);
		}
		
		int level = 1;
		while(true) {
			
		}
		
		
		
	}
}

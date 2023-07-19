import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("C:\\SSAFY\\SSAFY_LIVE\\Algorithm\\Baekjoon\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for(int i =0;i<N;i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0;j<N;j++) {
					map[i][j] = Integer.parseInt(s[i]);
				}
			}
			
			for(int[] arr: map) {
				
			}
			
		}
	}

}
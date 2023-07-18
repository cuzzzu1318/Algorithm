package nov_2022;

/*
 * ���̵� : 
 * ���̵��: 
 * �ð����⵵:
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA1493 {

	/*
	 * static int[] dp(ArrayList<int[]> d, int n, int i ) { int[] xy = new int[2];
	 * if(n ==1) { xy[0] = 1; xy[1] = 1; d.add(xy); }else { if(d.size()==n+1) {
	 * return d.get(n); }else {
	 * 
	 * xy[0] = dp(d, n-1, i)[0]+1; xy[1] = dp(d,n-1,i)[1]-1; if(xy[1]==0) { xy[0] =
	 * 1; xy[1] = ++i; }
	 * 
	 * } } }
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<int[]> arr = new ArrayList<>();
		int[] xy = new int[2];
		xy[0] = 0;
		xy[1] = 0;
		arr.add(xy);
		int x = 1;
		int y = 1;
		int n = 1;
		for (int i = 1; i < 100001; i++) {
			int[] xy1 = new int[2];
			xy1[0] = x;
			xy1[1] = y;
			arr.add(xy1);
			x++;
			y--;
			if (y == 0) {
				x = 1;
				y = ++n;
			}
		}
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			int[] pAdd = arr.get(p);
			int[] qAdd = arr.get(q);
			int[] pqAdd = new int[2];
			pqAdd[0] = pAdd[0] + qAdd[0];
			pqAdd[1] = pAdd[1] + qAdd[1];
			int ans = 0;
			for (int i = 1; i < 100001; i++) {
				if (arr.get(i)[0] == pqAdd[0] && arr.get(i)[1] == pqAdd[1]) {
					ans = i;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}